package com.example.myapplicationrealrealrealarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


public class MainActivitySong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_song);

        ImageButton moveButton5= findViewById(R.id.imageButton_song1);

        moveButton5.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),PracticeActivity5.class);
            startActivity(intent);
        });

        ImageButton moveButton6= findViewById(R.id.imageButton_song2);

        moveButton6.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),PracticeActivity6.class);
            startActivity(intent);
        });

        ImageButton moveButton7= findViewById(R.id.imageButton_song3);

        moveButton7.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),PracticeActivity7.class);
            startActivity(intent);
        });



    }


}