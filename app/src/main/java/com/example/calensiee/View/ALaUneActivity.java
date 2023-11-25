package com.example.calensiee.View;


import static com.example.calensiee.CalendarUtils.daysInWeekArray;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calensiee.CalendarUtils;
import com.example.calensiee.Event;
import com.example.calensiee.EventAdapter;
import com.example.calensiee.EventUtils;
import com.example.calensiee.R;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class ALaUneActivity extends AppCompatActivity implements EventAdapter.OnItemListener {
    private RecyclerView eventRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alaune);
        initWidgets();
        setEventAdpater();
        EventUtils.selectedEvent = new Event("",LocalDate.now().getYear(),LocalDate.now().getMonthValue(),
                LocalDate.now().getDayOfMonth(),LocalTime.now().getHour(),LocalTime.now().getMinute(),
                "","","",1);
    }

    private void initWidgets()
    {
        eventRecyclerView = findViewById(R.id.eventRecycleView);
    }

    private void setEventAdpater()
    {
        ArrayList<Event> oneWeekEvent = Event.eventsForDate(LocalDate.now());

        for(long i=1;i<7;i++){
            ArrayList<Event> dailyEvents = Event.eventsForDate(LocalDate.now().plusDays(i));
            dailyEvents.sort(Comparator.comparing(Event::getTimeOfEvent));
            oneWeekEvent.addAll(dailyEvents);
        }

        EventAdapter eventAdapter = new EventAdapter(oneWeekEvent, this,true);
        eventRecyclerView.setAdapter(eventAdapter);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    public void menuAction(View view)
    {
        startActivity(new Intent(this, MenuView.class));
    }


    @Override
    public void onItemClick(int position, Event event) {
        EventUtils.selectedEvent = event;
        startActivity(new Intent(this, EventDetailView.class));
    }

}
