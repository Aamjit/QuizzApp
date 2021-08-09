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

public class QuestionsHistory extends AppCompatActivity {

    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Patanjali is well known for the compilation of",
            "Who composed the Gayatri Mantra?",
            "Upanishads are books on",
            "The first newspaper published in India in 1780 was",
            "Which State is called the ' Cradle of Buddhism '?",
            "Which one of the following dynasties was ruling over North India at the time of Alexander's invasion",
            "Which Party was founded by Subhash Chandra Bose in the Year 1939 after he broke away from the congress?",
            "The Indus Valley Civilization was Non-Aryan because",
            "The first Mughal building with complete marble facing was",
            "The Indus Valley Civilization specialized in"
    };
    String answers[] = {"Yoga Sutra",
            "Vishvamitra",
            "Philosophy",
            "The Bengal Gazette or Calcutta General Advertiser",
            "Bihar",
            "Nanda",
            "Forward Bloc",
            "It was Urban",
            "Humayun's tomb",
            "Town Planning"};
    String opt[] = {
            "Yoga Sutra","Panchatantra","Brahma Sutra","Ayurveda",
            "Vishvamitra","Vasishtha","Indra","Parikshit",
            "Religion","Yoga","Law","Philosophy",
            "The Bengal Gazette or Calcutta General Advertiser","The Calcutta Chronicle","The Madras Courier","The Bombay Herald",
            "Sikkim","Bihar","Uttar Pradesh","Madhya Pradesh",
            "Nanda","Maurya","Sunga","Kanva",
            "Indian Freedom Party","Azad Hind Fauj","Revolutionary Front","Forward Bloc",
            "It was Urban","It has a pictographic script","It had an agricultural economy","It extended up to the narmada Valley",
            "Taj Mahal","Moti Masjid","Humayun's tomb","Itmad-ud-daulah's tomb",
            "Town Planning","Architecture","Craftsmanship","All of these"
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

