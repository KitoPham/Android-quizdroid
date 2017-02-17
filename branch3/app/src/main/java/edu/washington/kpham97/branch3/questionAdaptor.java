package edu.washington.kpham97.branch3;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static edu.washington.kpham97.branch3.R.id.answer1;
import static edu.washington.kpham97.branch3.R.id.questionTotal;
import static edu.washington.kpham97.branch3.R.id.topic;

/**
 * Created by Kito Pham on 2/16/2017.
 */

class questionAdaptor extends RecyclerView.Adapter<questionAdaptor.ViewHolder>{


    public questionAdaptor(){

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {;
        final QuestionObject currentQuestion = QuizApp.getData().questions[QuizApp.count];
        final String summary = QuizApp.getData().longDescript;
        final int totalq = QuizApp.getData().totalQuestions;
        holder.question.setText(currentQuestion.question);
        holder.answer1.setText(currentQuestion.answers[0]);
        holder.answer2.setText(currentQuestion.answers[1]);
        holder.answer3.setText(currentQuestion.answers[2]);
        holder.answer4.setText(currentQuestion.answers[3]);
        holder.questNum.setText("Question " + (QuizApp.count + 1));

        holder.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(holder.answer1.isChecked()){
                    QuizApp.lastanswer = 1;
                    MainActivity.change("answer");
                } else if (holder.answer2.isChecked()){
                    QuizApp.lastanswer = 2;
                    MainActivity.change("answer");
                } else if (holder.answer3.isChecked()){
                    QuizApp.lastanswer = 3;
                    MainActivity.change("answer");
                } else if (holder.answer4.isChecked()){
                   QuizApp.lastanswer = 4;
                    MainActivity.change("answer");
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView questNum;
        public TextView question;
        public Button button;
        public RadioButton answer1;
        public RadioButton answer2;
        public RadioButton answer3;
        public RadioButton answer4;
        public RadioGroup butgroup;


        public ViewHolder(View itemView) {
            super(itemView);
            questNum = (TextView) itemView.findViewById(R.id.questionNumber);
            question = (TextView) itemView.findViewById(R.id.question);
            button = (Button) itemView.findViewById(R.id.submit);
            answer1 = (RadioButton) itemView.findViewById(R.id.answer1);
            answer2 = (RadioButton) itemView.findViewById(R.id.answer2);
            answer3 = (RadioButton) itemView.findViewById(R.id.answer3);
            answer4 = (RadioButton) itemView.findViewById(R.id.answer4);
            butgroup = (RadioGroup) itemView.findViewById(R.id.questionsgroup);

        }
    }

}
