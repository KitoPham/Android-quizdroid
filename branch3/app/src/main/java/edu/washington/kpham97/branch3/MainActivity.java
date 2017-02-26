package edu.washington.kpham97.branch3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private static RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        change("start");

    }

    public static void change(String string){
        if (string.equals("start")){
            mAdapter = new listAdaptor();
            mRecyclerView.setAdapter(mAdapter);
        } else if (string.equals("overview")){
            mAdapter = new overviewAdaptor();
            mRecyclerView.setAdapter(mAdapter);
        } else if (string.equals("question")) {
            mAdapter = new questionAdaptor();
            mRecyclerView.setAdapter(mAdapter);
        } else if (string.equals("answer")){
            mAdapter = new answerAdaptor();
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}