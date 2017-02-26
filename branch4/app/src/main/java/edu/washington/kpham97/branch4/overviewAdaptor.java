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

class overviewAdaptor extends RecyclerView.Adapter<overviewAdaptor.ViewHolder> {


    public overviewAdaptor(){

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.overview_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {;
        final String title = QuizApp.getData().title;
        final String summary = QuizApp.getData().shortDescript;
        final int totalq = QuizApp.getData().totalQuestions;
        holder.topic.setText(title);
        holder.longD.setText(summary);
        holder.questionTotal.setText("There are "+ totalq +" questions.");
        holder.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.change("question");
            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView topic;
        public TextView longD;
        public Button button;
        public TextView questionTotal;

        public ViewHolder(View itemView) {
            super(itemView);
            topic = (TextView) itemView.findViewById(R.id.topicTitle);
            longD = (TextView) itemView.findViewById(R.id.summaryText);
            button = (Button) itemView.findViewById(R.id.begin);
            questionTotal = (TextView) itemView.findViewById(R.id.questionTotal);
        }
    }

}
