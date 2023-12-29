package com.example.myapplicationrealrealrealarray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PracticeActivity5 extends AppCompatActivity {
    private TextView textView;
    private ImageButton nextButton;
    private ImageButton endButton;
    private String[] lines;
    private int currentLineIndex;

    private EditText inputEditText;
    private String inputText;
    private SpannableStringBuilder spannableStringBuilder;
    private ForegroundColorSpan redForegroundColorSpan;

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice5);

        textView = findViewById(R.id.textView5);
        nextButton = findViewById(R.id.imageButton5);
        endButton = findViewById(R.id.imageButton2);
        inputEditText = findViewById(R.id.inputEditText5);

        // 메인 화면으로 넘어가는 '타자 연습 종료' 버튼
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // korea.txt 파일을 불러와서 줄별로 저장
        lines = loadTextFile(R.raw.trott2).split("\n");

        currentLineIndex = 0;
        displayCurrentLine();

        inputText = "";

        spannableStringBuilder = new SpannableStringBuilder();
        redForegroundColorSpan = new ForegroundColorSpan(Color.RED);

        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                inputText = s.toString();
                compareText();
            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PracticeActivity5.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLineIndex++;
                if (currentLineIndex < lines.length) {
                    displayCurrentLine();
                } else {
                    nextButton.setEnabled(false);
                    endButton.setEnabled(false);
                    Intent intent = new Intent(PracticeActivity5.this, FinishActivity.class); // 버튼 비활성화 후 MainActivity3로 이동
                    startActivity(intent);
                    handler.postDelayed(runnable, 5000); // 5초 후에 MainActivity2로 이동
                }
            }
        });

        inputEditText.requestFocus();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Handler의 작업을 취소하여 메모리 누수 방지
        handler.removeCallbacks(runnable);
    }

    // korea.txt 파일을 불러와서 문자열로 반환
    private String loadTextFile(int resourceId) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Resources resources = getResources();
            InputStream inputStream = resources.openRawResource(resourceId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void displayCurrentLine() {
        textView.setText(lines[currentLineIndex]);
        inputEditText.setText("");

        if (spannableStringBuilder != null) {
            spannableStringBuilder.clear();
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
    }

    private void compareText() {
        int inputLength = inputText.length();
        int lineLength = lines[currentLineIndex].length();

        spannableStringBuilder.clear();
        spannableStringBuilder.append(lines[currentLineIndex]);

        int minLength = Math.min(inputLength, lineLength);
        int[] flag = new int[minLength];

        for (int i = 0; i < minLength; i++) {
            if (inputText.charAt(i) != lines[currentLineIndex].charAt(i)) {
                flag[i] = 1;

            } else {
            }
        }

        for(int i = 0; i < flag.length; i++) {
            if (flag[i] == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.RED), i, i + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            }
            else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.BLACK), i, i + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            }
        }

        textView.setText(spannableStringBuilder);
    }
}