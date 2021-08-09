package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnRestart, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);

        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnExit = (Button) findViewById(R.id.exitButton);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionsGeography.correct +"\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong answers: " + QuestionsGeography.wrong +"\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Your Score: " + QuestionsGeography.correct +"\n");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        QuestionsGeography.correct = 0;
        QuestionsGeography.wrong = 0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (ResultActivity.this, MainActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right);
                startActivity(in);
            }
        });

        btnExit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }));

    }
}