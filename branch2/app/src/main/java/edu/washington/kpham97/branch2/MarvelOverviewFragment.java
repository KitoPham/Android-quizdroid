package edu.washington.kpham97.branch2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MarvelOverviewFragment extends Fragment {

    public MarvelOverviewFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        return inflater.inflate(R.layout.marvel_overview_fragment, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Button button = (Button) view.findViewById(R.id.begin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllActivity.changeToQuestion();
                Log.i("Button", "onClick: clicked ");
            }
        });
    }
}
