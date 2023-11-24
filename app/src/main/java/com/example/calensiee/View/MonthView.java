package com.example.calensiee.View;

import static com.example.calensiee.CalendarUtils.daysInMonthArray;
import static com.example.calensiee.CalendarUtils.daysInWeekArray;
import static com.example.calensiee.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calensiee.CalendarAdapter;
import com.example.calensiee.CalendarUtils;
import com.example.calensiee.R;
import com.example.calensiee.MainActivity;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonthView extends AppCompatActivity implements CalendarAdapter.OnItemListener
{
    private static TextView monthYearText;
    private static RecyclerView calendarRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        CalendarUtils.selectedDate = LocalDate.now();
        setMonthView();
    }

    private void setMonthView()
    {
        String month = monthYearFromDate(CalendarUtils.selectedDate);
        month = month.substring(0,1).toUpperCase() + month.substring(1);     //To capitalize the first lettre of the month
        monthYearText.setText(month);
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, (CalendarAdapter.OnItemListener) this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }
    public void previousMonthAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();
    }

    public void nextMonthAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
        setMonthView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

    public void weeklyAction(View view)
    {
        startActivity(new Intent(this, WeekViewActivity.class));
    }

    public void menuAction(View view)
    {
        startActivity(new Intent(this, MenuView.class));
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date == null){

        }else{
            CalendarUtils.selectedDate = date;      //Change the date
            startActivity(new Intent(this, WeekViewActivity.class));
        }
    }

    public void backToTodayAction(View view){
        CalendarUtils.selectedDate = LocalDate.now();
        setMonthView();
    }
}