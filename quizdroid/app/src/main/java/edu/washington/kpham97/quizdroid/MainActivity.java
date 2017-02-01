package edu.washington.kpham97.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;import edu.washington.kpham97.branch2.R;import edu.washington.kpham97.quizdroid.R;import edu.washington.kpham97.quizdroid.marvOverview;import edu.washington.kpham97.quizdroid.mathOverview;import edu.washington.kpham97.quizdroid.phyOverview;import edu.washington.kpham97.quizdroid.sameOverview;

public class MainActivity extends AppCompatActivity {

    private String[] topics = new String[]{
            "Math", "Physics", "Marvel Super Heroes", "Same"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                topics);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Listview", "position:" + position);
                Intent i = new Intent();
                if (position == 0){
                    i.setClass(getApplicationContext(),mathOverview.class);
                } else if (position == 1) {
                    i.setClass(getApplicationContext(),phyOverview.class);
                } else if (position == 2) {
                    i.setClass(getApplicationContext(),marvOverview.class);
                } else if (position == 3) {
                    i.setClass(getApplicationContext(),sameOverview.class);
                }

                startActivity(i);

            }
        });
    }
}
