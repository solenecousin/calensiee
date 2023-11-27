package com.example.calensiee.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calensiee.Lecture;
import com.example.calensiee.R;

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

    public void monCompteAction(View view)
    {
        startActivity(new Intent(this, MonCompteActivity.class));
    }
    public void Close(View view){
        this.finish();
    }
    public void ALaUneAction(View view){
        startActivity(new Intent(this, ALaUneActivity.class));
    }

    public void prevention(View view){ startActivity(new Intent(this, Lecture.class));}
}