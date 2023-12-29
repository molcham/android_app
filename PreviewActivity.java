package com.example.myapplicationrealrealrealarray;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        ImageButton moveButton= findViewById(R.id.imageButton_start);

        moveButton.setOnClickListener(view-> {
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
    }
}