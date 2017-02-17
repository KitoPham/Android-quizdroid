package edu.washington.kpham97.branch4;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kito Pham on 2/16/2017.
 */

class answerAdaptor extends RecyclerView.Adapter<answerAdaptor.ViewHolder> {


    public answerAdaptor(){

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {;
        final int correctNum = QuizApp.getData().questions[QuizApp.count].correct;
        if (QuizApp.lastanswer == correctNum){
            QuizApp.correctQuestions++;
        }
        holder.correctAnswer.setText(QuizApp.getData().questions[QuizApp.count].answers[correctNum - 1]);
        holder.yourAnswer.setText(QuizApp.getData().questions[QuizApp.count].answers[QuizApp.lastanswer - 1]);
        QuizApp.count++;
        holder.score.setText("You have " + QuizApp.correctQuestions + " out of " + QuizApp.count + " correct");
        if (QuizApp.count < QuizApp.getData().totalQuestions) {
            holder.button.setText("Next");
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.change("question");
                }
            });
        } else {
            holder.button.setText("Finish");
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.change("start");
                    QuizApp.reset();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView yourAnswer;
        public TextView correctAnswer;
        public Button button;
        public TextView score;

        public ViewHolder(View itemView) {
            super(itemView);
            yourAnswer = (TextView) itemView.findViewById(R.id.yourAnswerBox);
            correctAnswer = (TextView) itemView.findViewById(R.id.correctanswerBox);
            button = (Button) itemView.findViewById(R.id.nextButton);
            score = (TextView) itemView.findViewById(R.id.answeredRight);
        }
    }

}
