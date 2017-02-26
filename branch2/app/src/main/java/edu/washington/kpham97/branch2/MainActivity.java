package edu.washington.kpham97.branch2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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
                i.setClass(getApplicationContext(),AllActivity.class);
                if (position == 0){
                    i.putExtra("topic", "Math");
                    i.putExtra("total", 5);
                } else if (position == 1) {
                    i.putExtra("topic", "Physics");
                    i.putExtra("total", 3);
                } else if (position == 2) {
                    i.putExtra("topic", "Marvel");
                    i.putExtra("total", 2);
                } else if (position == 3) {
                    i.putExtra("topic", "Same");
                    i.putExtra("total", 2);
                }

                startActivity(i);

            }
        });
    }
}
