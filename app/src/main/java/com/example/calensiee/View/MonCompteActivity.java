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

import com.example.calensiee.CalendarAdapter;
import com.example.calensiee.CalendarUtils;
import com.example.calensiee.EmailPasswordActivity;
import com.example.calensiee.Event;
import com.example.calensiee.EventAdapter;
import com.example.calensiee.EventEditActivity;
import com.example.calensiee.R;
import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonCompteActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moncompte);
    }

    public void signOut(View view) {
        // [START auth_sign_out]
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, EmailPasswordActivity.class));
        // [END auth_sign_out]
    }

    public void menuAction(View view)
    {
        startActivity(new Intent(this, MenuView.class));
    }
}
