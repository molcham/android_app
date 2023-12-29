package com.example.myapplicationrealrealrealarray;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton moveButton= findViewById(R.id.imageButton_practice);

        moveButton.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(intent);
        });

        ImageButton moveButton2= findViewById(R.id.imageButton_write);

        moveButton2.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),DiaryActivity.class);
            startActivity(intent);
        });


    }


}