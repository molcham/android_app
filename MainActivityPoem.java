package com.example.myapplicationrealrealrealarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


public class MainActivityPoem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_poem);

        ImageButton moveButton1= findViewById(R.id.imageButton_poem1);

        moveButton1.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),PracticeActivity.class);
            startActivity(intent);
        });

        ImageButton moveButton2= findViewById(R.id.imageButton_poem2);

        moveButton2.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),PracticeActivity2.class);
            startActivity(intent);
        });



    }


}