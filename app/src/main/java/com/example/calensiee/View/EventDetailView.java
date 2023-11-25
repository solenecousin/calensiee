package com.example.calensiee.View;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calensiee.CalendarUtils;
import com.example.calensiee.Event;
import com.example.calensiee.EventUtils;
import com.example.calensiee.R;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDetailView extends AppCompatActivity {

    //public static Event selectedEvent;
    private static TextView eventName,eventClub,eventTime, eventDate, eventDuration, eventDescription,eventPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);
        initWidgets();
        setEvent();
    }
    private void initWidgets()
    {
        eventClub = findViewById(R.id.eventClubCellTV);
        eventName = findViewById(R.id.eventNameCellTV);
        eventTime = findViewById(R.id.eventTimeCellTV);
        eventDate = findViewById(R.id.eventDateTV);
        eventDuration = findViewById(R.id.eventDurationTV);
        eventDescription = findViewById(R.id.eventDescriptionTV);
        eventPlace = findViewById(R.id.eventPlaceTV);
    }

    private void setEvent(){
        eventName.setText(EventUtils.selectedEvent.getName());
        eventClub.setText(EventUtils.selectedEvent.getClub());
        eventDuration.setText(String.valueOf(EventUtils.selectedEvent.getDuration()));
        eventDescription.setText(EventUtils.selectedEvent.getDescription());
        eventPlace.setText(EventUtils.selectedEvent.getPlace());

        LocalTime time = LocalTime.of(EventUtils.selectedEvent.getmHour(),EventUtils.selectedEvent.getmMinute());
        eventTime.setText(time.toString());

        LocalDate date = LocalDate.of(EventUtils.selectedEvent.getmYear(),EventUtils.selectedEvent.getmMonth(),EventUtils.selectedEvent.getmDay());
        eventDate.setText(CalendarUtils.formattedDate(date));
    }
    public void backToLastActivityAction(View view){
        this.finish();
    }
}
