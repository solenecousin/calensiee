package com.example.calensiee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.calensiee.CalendarUtils.daysInMonthArray;
import static com.example.calensiee.CalendarUtils.monthYearFromDate;

import com.example.calensiee.View.MenuView;
import com.example.calensiee.View.MonthView;
import com.example.calensiee.View.WeekViewActivity;


public class MainActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener
{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    //private FirebaseFirestore mFirestore;
    //private FirebaseAuth mAuth;


    //@Override
    //public void onStart() {
        //super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //if(currentUser != null){
            //currentUser.reload();
        //}
    //}
    //@Override
    //public void onStop() {
      //  super.onStop();
        //if (mAdapter != null) {
        //    mAdapter.stopListening();
        //}
    //}
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
        setContentView(R.layout.menu);

        // Initialize Firebase Auth
        //mAuth = FirebaseAuth.getInstance();

        // Enable Firestore logging
        //FirebaseFirestore.setLoggingEnabled(true);

        // Initialize Firestore and the main RecyclerView
        //mFirestore = FirebaseUtil.getFirestore();

        //MonthView.initWidgets();
        //CalendarUtils.selectedDate = LocalDate.now();
        //MonthView.setMonthView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        if(date != null)
        {
            CalendarUtils.selectedDate = date;
        }
    }


}