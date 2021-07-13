package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        @Override
//        public void OpenCategory(View v){
//            Intent intent = new Intent(this, Category.class);
//            startActivity(intent);
//        }

    Button exit = (Button) findViewById(R.id.exit_btn);
    exit.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Exit");
            builder.setMessage("Do you want to Exit?");
            builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("Not now!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            }
        });

        ImageButton play = (ImageButton) findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(MainActivity.this,Category.class);
                startActivity(categoryIntent);
//                setContentView(R.layout.activity_category);
            }
        });
    }
}