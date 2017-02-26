package edu.washington.kpham97.branch2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class marvel2fragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    RadioButton correctAnswerBut;
    RadioButton incorrectAnswer1;
    RadioButton incorrectAnswer2;
    RadioButton incorrectAnswer3;

    RadioGroup questGroup;
    Button submitBut;

    String yourAnswer;
    String correctAnswer;
    boolean correct;

    public marvel2fragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_marvel2, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        correctAnswerBut = (RadioButton) view.findViewById(R.id.correct);
        correctAnswer = (String) correctAnswerBut.getText();
        questGroup = (RadioGroup) view.findViewById(R.id.questionsgroup);
        questGroup.setOnCheckedChangeListener(this);

        incorrectAnswer1 = (RadioButton) view.findViewById(R.id.incorrect);
        incorrectAnswer2 = (RadioButton) view.findViewById(R.id.incorrect2);
        incorrectAnswer3 = (RadioButton) view.findViewById(R.id.incorrect3);
        correct = false;

        submitBut = (Button) view.findViewById(R.id.submit);
        submitBut.setVisibility(View.GONE);
        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswerBut.isChecked()){
                    correct = true;
                    yourAnswer = (String) correctAnswerBut.getText();
                } else if (incorrectAnswer1.isChecked()){
                    yourAnswer = (String) incorrectAnswer1.getText();
                } else if (incorrectAnswer2.isChecked()){
                    yourAnswer = (String) incorrectAnswer2.getText();
                } else if (incorrectAnswer3.isChecked()){
                    yourAnswer = (String) incorrectAnswer3.getText();
                }

                AllActivity.changeToAnswer(correct, yourAnswer, correctAnswer);


            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        submitBut.setVisibility(View.VISIBLE);
    }
}
