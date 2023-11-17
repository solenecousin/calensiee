package com.example.calensiee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.calensiee.View.MenuView;
import com.example.calensiee.View.MonthView;
import com.example.calensiee.View.WeekViewActivity;


public class MainActivity extends AppCompatActivity
{

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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        startActivity(new Intent(this, EmailPasswordActivity.class));

    }

}