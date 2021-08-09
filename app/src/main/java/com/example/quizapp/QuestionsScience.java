
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

public class QuestionsScience extends AppCompatActivity {
    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The blue colour of the clear sky is due to",
            "Which one of the following types of waves are used in a night vision apparatus?",
            "The weight of an object will be minimum when it is placed at  ?",
            "In fireworks, the green flame is produced because of",
            "What does airbag, used for safety of car driver, contain?",
            "Which one of the following types of laser is used in laser printers?",
            "Potassium Permanganate is used for purifying drinking water, because",
            "The Ozone Layer restricts from",
            "The filament of an electric bulb is made of",
            "Which of the following plants is not capable of manufacturing own food?"
    };
    String answers[] = {"Dispersion of light","Infra-red waves",
            "The center of the Earth","Barium",
            "Sodium azide","Semiconductor laser",
            "it is an oxidising agent","Ultraviolet Radiation",
            "tungsten","Mushroom"};
    String opt[] = {
            "Diffractio of Light","Dispersion of light","Reflection of light","Refraction of light",
            "Radio Waves","Microwaves","Infra-red waves","None of the above",
            "The North Pole","The South Pole","The Equator","The center of the Earth",
            "Sodium","Potassium","Barium","Mercury",
            "Sodium bicarbonate","Sodium azide","Sodium nitrite","Sodium peroxide",
            "Semiconductor laser","Dye laser","Gas laser","Excimer laser",
            "It is a sterilising agent","It dissolves the iumpurities of water","It is a reducing agent","it is an oxidising agent",
            "Infrared Rays","Radio waves","Ultraviolet Radiation","X-rays and Gamma rays",
            "tungsten","Nichrome","Graphite","Iron",
            "Algae","Mushroom","Carrot","Cabbage"
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

