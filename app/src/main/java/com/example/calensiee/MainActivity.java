package com.example.calensiee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomMenuFragment.OnItemClickListener,MoisFragment.OnItemClickListener {
    //Button boutonMois;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        SemaineFragment semaineFragment = new SemaineFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment_layout, semaineFragment)
                .add(R.id.menu_fragment_layout, bottomMenuFragment)
                .comit();

    }
//test push

    //@Override // for nested class ListFragment.onItemClickListener
    public void onItemSelectedBottom(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // Replace the current fragment with a new one
        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        SemaineFragment semaineFragment = new SemaineFragment();
        MoisFragment moisFragment = new MoisFragment();
        ReglagesFragment reglagesFragment = new ReglagesFragment();


        if(position==1){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_layout, semaineFragment)
                    //.add(R.id.main_fragment_layout, bottomMenuFragment)
                    .commit();
        }
        else if(position==2){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_layout, moisFragment)
                    //.add(R.id.main_fragment_layout, bottomMenuFragment)
                    .commit();
        }
        else if(position==3){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_layout, reglagesFragment)
                    //.add(R.id.main_fragment_layout, bottomMenuFragment)
                    .commit();
        }
    }

    public void onItemSelectedJour(int position, ArrayList<Integer> dayEvent) {
        Bundle b = new Bundle();
        int taille=dayEvent.size();

        //int dayEvent=mois.getListeEvents().get(0);
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // Replace the current fragment with a new one
        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        EvenementFragment evenementFragment = new EvenementFragment();

        for(int k=0; k<taille; k++){
            if(position== dayEvent.get(k)){
                b.putString("dayEvent", String.valueOf(position));
                b.putString("monthEvent", String.valueOf(11));
                evenementFragment.setArguments(b);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment_layout, evenementFragment)
                        .commit();
            }
        }

    }
}

