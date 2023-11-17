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
import androidx.recyclerview.widget.RecyclerView;

import com.example.calensiee.CalendarUtils;
import com.example.calensiee.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class MenuView extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void monthAction(View view)
    {
        startActivity(new Intent(this, MonthView.class));
    }
    public void Close(View view){
        startActivity(new Intent(this, MonthView.class));
    }

}