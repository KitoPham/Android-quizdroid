package edu.washington.kpham97.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class answerPage extends AppCompatActivity implements View.OnClickListener {

    String yourAnswer;
    String correctAnswer;
    Intent nIntent;
    String topic;
    int correctNum;
    int total;
    boolean finalQuest;

    Button nextPage;
    TextView yourAnswerTxt;
    TextView correctAnswerTxt;
    TextView correctNumTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_page);

        nIntent = getIntent();
        correctNum = nIntent.getIntExtra("correctNum", 0);
        total = nIntent.getIntExtra("total", 0);
        topic = nIntent.getStringExtra("topic");
        yourAnswer = nIntent.getStringExtra("yourAnswer");
        correctAnswer = nIntent.getStringExtra("correctAnswer");
        finalQuest = nIntent.getBooleanExtra("finalQuest", false);

        yourAnswerTxt = (TextView) findViewById(R.id.yourAnswerBox);
        yourAnswerTxt.setText(yourAnswer);

        correctAnswerTxt = (TextView) findViewById(R.id.correctanswerBox);
        correctAnswerTxt.setText(correctAnswer);

        correctNumTxt = (TextView) findViewById(R.id.answeredRight);
        correctNumTxt.setText("You have "+ correctNum + " out of " + total + " correct");

        nextPage = (Button) findViewById(R.id.nextButton);
        if (finalQuest){
            nextPage.setText("Finish");
        } else {
            nextPage.setText("Next");
        }
        nextPage.setOnClickListener(this);



    }

    @Override
    public void onClick(View v){

        Intent i = new Intent();
        i.putExtra("total",total);
        i.putExtra("correctNum",correctNum);

        if (!finalQuest) {

            if (topic.equals("Math1")) {
                i.setClass(getApplicationContext(), math2.class);
            } else if (topic.equals("Math2")) {
                i.setClass(getApplicationContext(), math3.class);
            } else if (topic.equals("Math3")) {
                i.setClass(getApplicationContext(), math4.class);
            } else if (topic.equals("Math4")) {
                i.setClass(getApplicationContext(), math5.class);
            } else if (topic.equals("Physics1")) {
                i.setClass(getApplicationContext(), physics2.class);
            } else if (topic.equals("Physics2")) {
                i.setClass(getApplicationContext(), physics3.class);
            } else if (topic.equals("Physics3")) {
                i.setClass(getApplicationContext(), physics4.class);
            }  else if (topic.equals("Physics4")) {
                i.setClass(getApplicationContext(), physics5.class);
            } else if (topic.equals("Marvel1")) {
                i.setClass(getApplicationContext(), marv2.class);
            } else if (topic.equals("Marvel2")) {
                i.setClass(getApplicationContext(), marv3.class);
            } else if (topic.equals("Marvel3")) {
                i.setClass(getApplicationContext(), marv4.class);
            }  else if (topic.equals("Marvel4")) {
                i.setClass(getApplicationContext(), marv5.class);
            }  else if (topic.equals("Same1")) {
                i.setClass(getApplicationContext(), same2.class);
            } else if (topic.equals("Same2")) {
                i.setClass(getApplicationContext(), same3.class);
            } else if (topic.equals("Same3")) {
                i.setClass(getApplicationContext(), same4.class);
            }  else if (topic.equals("Same4")) {
                i.setClass(getApplicationContext(), same5.class);
            }
        } else {
            i.setClass(getApplicationContext(), MainActivity.class);
        }

        startActivity(i);
    }
}
