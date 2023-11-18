package com.example.calensiee;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.calensiee.View.MenuView;
import com.example.calensiee.View.MonthView;
import com.example.calensiee.View.WeekViewActivity;


import java.time.LocalDate;

public class preLoad extends AppCompatActivity implements CalendarAdapter.OnItemListener {

    public void weeklyAction(View view)
    {
        startActivity(new Intent(this, WeekViewActivity.class));
    }
    public void menuAction(View view)
    {
        startActivity(new Intent(this, MenuView.class));
    }
    public void monthAction(View view)
    {
        startActivity(new Intent(this, MonthView.class));
    }
    public void Close(View view){
        startActivity(new Intent(this, MonthView.class));
    }
    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date != null)
        {
            CalendarUtils.selectedDate = date;
        }
    }
}
