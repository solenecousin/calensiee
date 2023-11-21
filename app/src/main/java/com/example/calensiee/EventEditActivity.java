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

public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET;
    private TextView eventDateTV, eventTimeTV;
    private LocalTime time;
    private LocalDate date;
    private Button button;

    private int mYear,mMonth,mDay,mHour,mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        date = LocalDate.now();
        //eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        //eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));



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
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        Event newEvent = new Event(eventName, LocalDate.of(mYear,mMonth,mDay), LocalTime.of(mHour,mMinute));
        Event.eventsList.add(newEvent);
        finish();
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
                eventDateTV.setText("Date : "+CalendarUtils.formattedDate(LocalDate.of(mYear,mMonth,mDay)));

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
                eventTimeTV.setText("Time : "+CalendarUtils.formattedTime(LocalTime.of(mHour,mMinute)));

            }
        }, time.getHour(), time.getMinute(), true);

        timePickerDialog.show();
    }
}

