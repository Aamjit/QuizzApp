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

public class QuestionsSports extends AppCompatActivity {
    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Holkar Trophy is associated with which sport?",
            "Who is the first Indian woman to win an Asian Games gold in 400m run",
            "With which game does Davis Cup is associated",
            "The first Indian to cross seven important seas by swimming ____ ?",
            "With which game does Santosh Trophy is associated",
            "What is the name of person which controls a football match",
            "The name Kunjarani Devi is associated with",
            "The 2017 Indian Premier League (IPL 2017) first match on 5 April, 2017 was held in ?",
            "Which one of the following Cricketers has been declared by the ICC as 'Cricketer of the Twentieth Century '",
            "Nehru trophy is related to which game?"
    };
    String answers[] = {"Bridge","P.T. Usha",
            "Lawn Tennis","Bula Chaudhury",
            "National Football","A referee",
            "Weight Lifting","Hyderabad",
            "Kapil Dev","Football"};
    String opt[] = {
            "Bridge","Hockey","Football","Badminton",
            "M.L. Valsamma","P.T. Usha","Kamaljit Sandhu","K.Maleshwari",
            "Hockey","Table Tennis","Lawn Tennis","Polo",
            "Amrendra Singh","Bula Chaudhury","Junko Taibei","Yuri Gagarin",
            "Tennis","Cricket","National Football","Golf",
            "A referee","An Umpire","A Spectator","A Goalkeeper",
            "Weight Lifting","Target Shooting","Athletics","Swimming",
            "Bangalore","Delhi","Hyderabad","Kolkata",
            "Sachin Tendulkar","Kapil Dev","Rahul Dravid","Anil Kumble",
            "Cricket","Badminton","Football","Hockey"
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

