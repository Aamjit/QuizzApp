package com.example.quizapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        ImageButton back = (ImageButton) findViewById(R.id.revert);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Button option1 = (Button) findViewById(R.id.option1);
        Button option2 = (Button) findViewById(R.id.option2);
        Button option3 = (Button) findViewById(R.id.option3);
        Button option4 = (Button) findViewById(R.id.option4);
        Button option5 = (Button) findViewById(R.id.option5);


//        Intent intent = new Intent(getApplicationContext(), Difficulty.class);

        option1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), QuestionsGeography.class);
                startActivity(intent1);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right);

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), QuestionsHistory.class);
                startActivity(intent2);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right);

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), QuestionsSports.class);
                startActivity(intent3);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right);

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), QuestionsSports.class);
                startActivity(intent4);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right);

            }
        });

        option5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), QuestionsScience.class);
                startActivity(intent5);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right);

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home) {
                finish();
            overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_left);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
