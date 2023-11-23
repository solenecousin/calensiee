package com.example.calensiee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.calensiee.View.EventDetailView;
import com.example.calensiee.View.MenuView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, EventDetailView.class));
    }


}