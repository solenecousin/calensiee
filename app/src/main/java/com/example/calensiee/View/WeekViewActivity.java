package com.example.calensiee.View;

import static com.example.calensiee.CalendarUtils.daysInWeekArray;
import static com.example.calensiee.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calensiee.CalendarAdapter;
import com.example.calensiee.CalendarUtils;
import com.example.calensiee.Event;
import com.example.calensiee.EventAdapter;
import com.example.calensiee.EventEditActivity;
import com.example.calensiee.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
        setEventAdpater();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventRecyclerView = findViewById(R.id.eventRecycleView);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
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
        setEventView(event);
    }

    private void setEventView(Event event) {


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
        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);     //Select events of a specific day
        dailyEvents.sort(Comparator.comparing(Event::getTime));                             //Sort events by time
        EventAdapter eventAdapter = new EventAdapter(dailyEvents, this,false);
        eventRecyclerView.setAdapter(eventAdapter);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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