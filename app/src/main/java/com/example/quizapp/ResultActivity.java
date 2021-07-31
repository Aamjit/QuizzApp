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
        sb.append("Correct answers: " + Questions.correct +"\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong answers: " + Questions.wrong +"\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Your Score: " + Questions.correct +"\n");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Questions.correct = 0;
        Questions.wrong = 0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (ResultActivity.this, MainActivity.class);
                ResultActivity.this.finish();
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