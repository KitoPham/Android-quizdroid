package edu.washington.kpham97.branch2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.Fragment;


public class AnswerFragment extends Fragment implements View.OnClickListener {

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

    public AnswerFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        return inflater.inflate(R.layout.answer_fragment, container, false);
    }



    public void onViewCreated(View view, Bundle savedInstanceState) {

        Bundle args = this.getArguments();
        correctNum = args.getInt("correct", 0);
        yourAnswer = args.getString("yourAnswer");
        correctAnswer = args.getString("correctAnswer");
        total = args.getInt("total",0);
        finalQuest = args.getBoolean("finalQuestion", false);

        yourAnswerTxt = (TextView) view.findViewById(R.id.yourAnswerBox);
        yourAnswerTxt.setText(yourAnswer);

        correctAnswerTxt = (TextView) view.findViewById(R.id.correctanswerBox);
        correctAnswerTxt.setText(correctAnswer);

        correctNumTxt = (TextView) view.findViewById(R.id.answeredRight);
        correctNumTxt.setText("You have "+ correctNum + " out of " + total + " correct");

        nextPage = (Button) view.findViewById(R.id.nextButton);
        if (finalQuest){
            nextPage.setText("Finish");
        } else {
            nextPage.setText("Next");
        }
        nextPage.setOnClickListener(this);



    }

    @Override
    public void onClick(View v){

        if (!finalQuest) {
            AllActivity.changeToQuestion();
        } else {
            Intent i = new Intent();
            i.setClass(getActivity(), MainActivity.class);
            startActivity(i);
        }


    }
}
