package com.example.calensiee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

import com.example.calensiee.View.MenuView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Lecture extends AppCompatActivity {
    private TextView lecture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fichier_txt_activity);
        lecture = findViewById(R.id.lireTV);

        try {
            PlayWithRawFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void PlayWithRawFiles() throws IOException {

        try {
            InputStream fIn = getResources().openRawResource(R.raw.test);
            InputStreamReader ipsr = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(ipsr);

            int c;
            String tmp = "";
            while ((c = br.read()) != -1) {
                tmp = tmp + Character.toString((char) c);
            }
            lecture.setText(tmp);


        } catch (FileNotFoundException e) {
            e.printStackTrace();


        }
    }

    public void backToMenu(View view){
        startActivity(new Intent(this, MenuView.class));
    }
}
