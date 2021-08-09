
package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsCulture extends AppCompatActivity {
    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "In which of the following festivals are boat races a special feature?",
            "Which of the following places is famous for Chikankari work, which is a traditional art of embroidery?",
            "Tansen, a great musician of his time, was in the court of –",
            "Who put up the most stiff resistance against the British in India?",
            "The Main headquarters of Sahitya Akademi is located at",
            "Which among the following is a folk dance of India?",
            "The cultivation of crops in regions with an annual rainfall of 750mm is called as ____.",
            "The Court language of the Mughals was",
            "Madhubani painting is famous in which of the following state?",
            "Which classical dance is famous in Tamil Nadu?"
    };
    String answers[] = {"Onam","Lucknow",
            "Akbar","The Marathas",
            "New Delhi","Garba",
            "Dry Land Farming","Persian",
            "Bihar","Bharatanatyam"};
    String opt[] = {
            "Rongali Bihu","Onam","Pongal","Navratri",
            "Hyderabad","Lucknow","Mysore","Jaipur",
            "Akbar","Shahjahan","BahadurShah","Jahangir",
            "The Rajputs","The Marathas","The Moghals","The Sikhs",
            "Mumbai","Chennai","New Delhi","Kolkata",
            "Garba","Kathakali","Manipuri","Mohiniattam",
            "Wet Farming","Intensive farming","Rain Fed Farming","Dry Land Farming",
            "Hindiv","Arabic","Persian","Urdu",
            "Uttar Pradesh","Kerala","Bihar","Tamil Nadu",
            "Kuchipudi","Mohiniattam","Bharatanatyam","Kathakali"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.scoreValue);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
//        String name= intent.getStringExtra("myname");

//        if (name.trim().equals(""))
        textView.setText("Hello User");

        submitButton=(Button)findViewById(R.id.buttonNextQuestion);
        quitButton=(Button)findViewById(R.id.buttonQuit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersGroup);
        rb1=(RadioButton)findViewById(R.id.radioButton1);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uAns = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uAns.getText().toString();

                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}

