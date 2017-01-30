package edu.washington.kpham97.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class math2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioButton correctAnswerBut;
    RadioButton incorrectAnswer1;
    RadioButton incorrectAnswer2;
    RadioButton incorrectAnswer3;

    RadioGroup questGroup;
    Button submitBut;

    String yourAnswer;
    String correctAnswer;
    Intent nIntent;
    String topic;
    int correctNum;
    int total;
    boolean finalQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math2);

        nIntent = getIntent();
        correctNum = nIntent.getIntExtra("correctNum", 0);
        total = nIntent.getIntExtra("total", 0);
        topic = "Math2";
        finalQuest = false;


        correctAnswerBut = (RadioButton) findViewById(R.id.correct);
        correctAnswer = (String) correctAnswerBut.getText();
        questGroup = (RadioGroup) findViewById(R.id.questionsgroup);
        questGroup.setOnCheckedChangeListener(this);

        incorrectAnswer1 = (RadioButton) findViewById(R.id.incorrect);
        incorrectAnswer2 = (RadioButton) findViewById(R.id.incorrect2);
        incorrectAnswer3 = (RadioButton) findViewById(R.id.incorrect3);

        submitBut = (Button) findViewById(R.id.submit);
        submitBut.setVisibility(View.GONE);
        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswerBut.isChecked()) {
                    correctNum++;
                    yourAnswer = (String) correctAnswerBut.getText();
                } else if (incorrectAnswer1.isChecked()) {
                    yourAnswer = (String) incorrectAnswer1.getText();
                } else if (incorrectAnswer2.isChecked()) {
                    yourAnswer = (String) incorrectAnswer2.getText();
                } else if (incorrectAnswer3.isChecked()) {
                    yourAnswer = (String) incorrectAnswer3.getText();
                }

                total++;
                Intent i = new Intent(getApplicationContext(), answerPage.class);
                i.putExtra("yourAnswer", yourAnswer);
                i.putExtra("total", total);
                i.putExtra("correctNum", correctNum);
                i.putExtra("topic", topic);
                i.putExtra("correctAnswer", correctAnswer);
                i.putExtra("finalQuest", finalQuest);
                startActivity(i);

            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        submitBut.setVisibility(View.VISIBLE);
    }
}