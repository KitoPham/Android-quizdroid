package edu.washington.kpham97.quizdroid;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Kito Pham on 2/16/2017.
 */

class listAdaptor extends RecyclerView.Adapter<listAdaptor.ViewHolder> {


    public listAdaptor(){
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {;
        QuizApp.setTopic(position);
        final String title = QuizApp.getData().title;
        final String shortDes = QuizApp.getData().shortDescript;
        holder.textview.setText(title);
        holder.shortD.setText(shortDes);
        holder.topic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                QuizApp.setTopic(position);
                MainActivity.change("overview");
            }
        });


    }

    @Override
    public int getItemCount() {
        return QuizApp.getSize();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textview;
        public TextView shortD;
        public LinearLayout topic;

        public ViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.listTopic);
            shortD = (TextView) itemView.findViewById(R.id.shortDescript);
            topic = (LinearLayout) itemView.findViewById(R.id.topic);
        }
    }

}
