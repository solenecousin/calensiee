package com.example.calensiee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.calensiee.View.ALaUneActivity;
import com.example.calensiee.View.MenuView;
import com.example.calensiee.View.MonCompteActivity;
import com.example.calensiee.View.MonthView;
import com.example.calensiee.View.WeekViewActivity;

import org.checkerframework.checker.units.qual.C;

import java.time.LocalDate;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.auth);
        startActivity(new Intent(this, ALaUneActivity.class));

    }


}