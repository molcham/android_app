package com.example.myapplicationrealrealrealarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageButton moveButton3= findViewById(R.id.imageButton_poem);

        moveButton3.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(), MainActivityPoem.class);
            startActivity(intent);
        });

        ImageButton moveButton4= findViewById(R.id.imageButton_seong);

        moveButton4.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(), MainActivitySeong.class);
            startActivity(intent);
        });

        ImageButton moveButton5= findViewById(R.id.imageButton_song);

        moveButton5.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(), MainActivitySong.class);
            startActivity(intent);
        });



    }


}