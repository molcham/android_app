package com.example.myapplicationrealrealrealarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


public class MainActivitySeong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_seong);

        ImageButton moveButton3= findViewById(R.id.imageButton_seong1);

        moveButton3.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),PracticeActivity3.class);
            startActivity(intent);
        });

        ImageButton moveButton4= findViewById(R.id.imageButton_seong2);

        moveButton4.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),PracticeActivity4.class);
            startActivity(intent);
        });



    }


}