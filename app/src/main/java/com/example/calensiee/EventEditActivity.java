package com.example.calensiee;


import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalDate;
import java.time.LocalTime;


import androidx.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET;
    private TextView eventDateET, eventTimeET, eventPlaceET,eventDurationET,eventClubET,eventDescriptionET;
    private LocalTime time;
    private LocalDate date;
    private Button button;

    DatabaseReference reference;
    FirebaseDatabase db;

    private int mYear,mMonth,mDay,mHour,mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        date = LocalDate.now();

        mYear   = date.getYear();
        mMonth  = date.getMonthValue();
        mDay    = date.getDayOfMonth();
        eventDateET.setText("Date : " + CalendarUtils.formattedDate(LocalDate.of(mYear,mMonth,mDay)));

        mHour   = time.getHour();
        mMinute = time.getMinute();
        eventTimeET.setText("Time : "+CalendarUtils.formattedTime(LocalTime.of(mHour,mMinute)));

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker(); // Open date picker dialog
                openTimePicker(); //Open time picker dialog
            }
        });
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateET = findViewById(R.id.eventDateTV);
        eventTimeET = findViewById(R.id.eventTimeTV);
        eventPlaceET = findViewById(R.id.eventPlaceTV);
        eventClubET = findViewById(R.id.eventClubTV);
        eventDurationET = findViewById(R.id.eventDurationTV);
        eventDescriptionET = findViewById(R.id.eventDescriptionTV);
    }

    public void saveEventAction(View view)
    {
        if(eventNameET.getText().toString().isEmpty() || eventPlaceET.getText().toString().isEmpty() ||
                eventClubET.getText().toString().isEmpty() || eventDurationET.getText().toString().isEmpty()){

            Toast.makeText(EventEditActivity.this, "Please fill in all fields.",
                    Toast.LENGTH_SHORT).show();

        }
        else if(eventDescriptionET.getText().toString().isEmpty()){
            String eventName = eventNameET.getText().toString();
            String eventPlace = eventPlaceET.getText().toString();
            String eventClub = eventClubET.getText().toString();
            int eventDuration = Integer.valueOf(eventDurationET.getText().toString());
            Event newEvent = new Event(eventName, LocalDate.of(mYear,mMonth,mDay), LocalTime.of(mHour,mMinute),eventPlace,"No description for this event.",eventDuration,eventClub);

            /**
            db=FirebaseDatabase.getInstance();
            reference = db.getReference("Event");
            reference.child(eventName).setValue(newEvent).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(EventEditActivity.this,"Successfuly Updated",Toast.LENGTH_SHORT).show();
                }
            });
*/
            Event.eventsList.add(newEvent);
            finish();
        }
        else{
            String eventName = eventNameET.getText().toString();
            String eventPlace = eventPlaceET.getText().toString();
            String eventClub = eventClubET.getText().toString();
            int eventDuration = Integer.valueOf(eventDurationET.getText().toString());
            String eventDescription = eventDescriptionET.getText().toString();
            Event newEvent = new Event(eventName, LocalDate.of(mYear,mMonth,mDay), LocalTime.of(mHour,mMinute),eventPlace,eventDescription,eventDuration,eventClub);
/**
            db=FirebaseDatabase.getInstance();
            reference = db.getReference("Event");
            reference.child(eventName).setValue(newEvent).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(EventEditActivity.this,"Successfuly Updated",Toast.LENGTH_SHORT).show();
                }
            });
*/
            Event.eventsList.add(newEvent);
            finish();
        }
    }
    public void backToWeekAction(View view){
        this.finish();
    }

    private void openDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.Theme_Calensiee , new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mYear = year;
                mMonth = month+1;
                mDay = day;
                //Showing the picked value in the textView
                eventDateET.setText("Date : " + CalendarUtils.formattedDate(LocalDate.of(mYear,mMonth,mDay) ) );
            }
        }, date.getYear(), date.getMonthValue()-1, date.getDayOfMonth());

        datePickerDialog.show();
    }


    private void openTimePicker(){

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.Theme_Calensiee, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                mHour = hour;
                mMinute = minute;
                //Showing the picked value in the textView
                eventTimeET.setText("Time : "+CalendarUtils.formattedTime(LocalTime.of(mHour,mMinute)));

            }
        }, time.getHour(), time.getMinute(), true);

        timePickerDialog.show();
    }
}

