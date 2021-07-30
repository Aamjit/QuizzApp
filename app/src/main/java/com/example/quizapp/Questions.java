package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The Tropic of Cancer does not pass through which of the Indian State?",
            "Which river of India is called Vridha Ganga?",
            "Which of the following is a Trans-Himalayan river?",
            "India lies in which hemisphere?",
            "Which is the eastern most state in India?",
            "The driest part in india is in",
            "Eastern Ghats and Western Ghats meet at the",
            "Guwahati is situated on the bank of the river",
            "Which of the following is the largest lagoon in India?",
            "Which state of India has the smallest land area?"
    };
    String answers[] = {"Odisha","Godavari","Indus","Northern and Eastern","Arunachal Pradesh","Western Rajasthan","Nilgiri Hills","Brahmaputra","Chilka lagoon","Goa"};
    String opt[] = {
            "Madhya Pradesh","West Bengal","Rajasthan","Odisha",
            "Krishna","Godavari","Kaveri","Narmada",
            "Ganga","Yamuna","Indus","Ravi",
            "Northern and Eastern","Southern and Eastern","Northern and Western","Southern and Western",
            "Assam","Nagaland","Arunachal Pradesh","Manipur",
            "Western Rajasthan","Punjab","Bihar","GUjarat",
            "Annamalai Hillls","Palani Hills","Nilgiri Hills","Cardamon Hills",
            "Teesta","Brahmaputra","Hooghly","Sone",
            "Vembanad lagoon","Chilka lagoon","Pulicat lagoon","Kolleru",
            "Goa","Nagaland","Sikkim","Tripura"
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