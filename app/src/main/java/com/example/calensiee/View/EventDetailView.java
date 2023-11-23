package com.example.calensiee.View;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calensiee.R;

public class EventDetailView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);
    }

    public void backToLastActivityAction(View view){
        this.finish();
    }
}
