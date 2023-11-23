package com.example.calensiee.View;


import static com.example.calensiee.CalendarUtils.daysInWeekArray;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calensiee.CalendarUtils;
import com.example.calensiee.Event;
import com.example.calensiee.EventAdapter;
import com.example.calensiee.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class ALaUneActivity extends AppCompatActivity implements EventAdapter.OnItemListener {
    private RecyclerView eventListView;
    //private ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alaune);
        //initWidgets();
        //setNextEvents();
    }

    private void initWidgets()
    {
        eventListView = findViewById(R.id.eventRecycleView);
    }

    private void setNextEvents()
    {
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);
        //setEventAdpater();
    }

    //@Override
    //protected void onResume()
    //{
    //    super.onResume();
    //    setEventAdpater();
    //}

    private void setEventAdpater()
    {
        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);
        EventAdapter eventAdapter = new EventAdapter(dailyEvents, this);
        eventListView.setAdapter(eventAdapter);
    }

    public void menuAction(View view)
    {
        startActivity(new Intent(this, MenuView.class));
    }


    @Override
    public void onItemClick(int position, Event event) {

    }

    @Override
    public void onItemClick(int position, LocalDate date) {

    }

}
