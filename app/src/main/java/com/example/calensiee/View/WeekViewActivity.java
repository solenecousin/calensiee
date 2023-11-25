package com.example.calensiee.View;

import static com.example.calensiee.CalendarUtils.daysInWeekArray;
import static com.example.calensiee.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calensiee.AccountUtil;
import com.example.calensiee.CalendarAdapter;
import com.example.calensiee.CalendarUtils;
import com.example.calensiee.EmailPasswordActivity;
import com.example.calensiee.Event;
import com.example.calensiee.EventAdapter;
import com.example.calensiee.EventEditActivity;
import com.example.calensiee.EventUtils;
import com.example.calensiee.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WeekViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener, EventAdapter.OnItemListener
{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private RecyclerView eventRecyclerView;
    private boolean showButtonNewEvent;
    DatabaseReference reference;
    private Button btn;
    private static ArrayList<Event> events;

    private Firebase mEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
        setEventAdpater();
        showButton();
        EventUtils.selectedEvent = new Event("",LocalDate.now().getYear(),LocalDate.now().getMonthValue(),
                LocalDate.now().getDayOfMonth(),LocalTime.now().getHour(),LocalTime.now().getMinute(),
                "","","",1);
    }

    private void showButton() {
        if(AccountUtil.isAdmin){
            this.btn.setVisibility(Button.VISIBLE);
        }else{
            this.btn.setVisibility(Button.GONE);
        }
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventRecyclerView = findViewById(R.id.eventRecycleView);
        btn = findViewById(R.id.newEventButton);

    }

    private void setWeekView()
    {
        String month = monthYearFromDate(CalendarUtils.selectedDate);
        month = month.substring(0,1).toUpperCase() + month.substring(1);     //To capitalize the first lettre of the month
        monthYearText.setText(month);
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);

    }


    public void previousWeekAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }

    @Override
    public void onItemClick(int position, Event event) {
        EventUtils.selectedEvent = event;
        startActivity(new Intent(this, EventDetailView.class));
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendarUtils.selectedDate = date;      //Change the date
        setWeekView();                          //Set the weekView at the selected date
        setEventAdpater();                      //Show the events of the selected dates
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    private void setEventAdpater()
    {
        reference = FirebaseDatabase.getInstance("https://calensiee-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference().child("events").child(String.valueOf(CalendarUtils.selectedDate.getYear()))
                .child(String.valueOf(CalendarUtils.selectedDate.getMonth()));

        reference.child(String.valueOf(CalendarUtils.selectedDate.getDayOfMonth())).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                        if (task.getResult().exists()) {

                            Toast.makeText(WeekViewActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            DataSnapshot dataSnapshot = task.getResult();

                            String name = String.valueOf(dataSnapshot.child("name").getValue());
                            String club = String.valueOf(dataSnapshot.child("club").getValue());
                            String description = String.valueOf(dataSnapshot.child("description").getValue());
                            String place = String.valueOf(dataSnapshot.child("place").getValue());
                            int year = Integer.valueOf(String.valueOf(dataSnapshot.child("mYear").getValue()));
                            int month = Integer.valueOf(String.valueOf(dataSnapshot.child("mMonth").getValue()));
                            int day = Integer.valueOf(String.valueOf(dataSnapshot.child("mDay").getValue()));
                            int hour = Integer.valueOf(String.valueOf(dataSnapshot.child("mHour").getValue()));
                            int minute = Integer.valueOf(String.valueOf(dataSnapshot.child("mMinute").getValue()));
                            int duration = Integer.valueOf(String.valueOf(dataSnapshot.child("duration").getValue()));

                            Event newEvent = new Event(name,year,month,day,hour,minute,place,description,club,duration);
                            events.add(newEvent);
                        } else {
                            Toast.makeText(WeekViewActivity.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });


        /**
         *
         * private ArrayList<Event> eventsList = new ArrayList<>();
         *
         *     public ArrayList<Event> eventsForDate(LocalDate date)
         *     {
         *
         *         ArrayList<Event> events = new ArrayList<>();
         *         for(Event event : this.eventsList)
         *         {
         *             if(LocalDate.of(event.getmYear(),event.getmMonth(),event.getmDay()).equals(date))
         *                 events.add(event);
         *         }
         *         return events;
         *     }
        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);     //Select events of a specific day
        //dailyEvents.sort(Comparator.comparing(Event::getTimeOfEvent));                             //Sort events by time
        EventAdapter eventAdapter = new EventAdapter(dailyEvents, this,false);
        eventRecyclerView.setAdapter(eventAdapter);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
         */
    }

    public void newEventAction(View view)
    {
        startActivity(new Intent(this, EventEditActivity.class));
    }
    public void backToMonthAction(View view){
        this.finish();
    }
    public void backToTodayAction(View view){
        CalendarUtils.selectedDate = LocalDate.now();
        setWeekView();
        setEventAdpater();
    }


}