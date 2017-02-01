package edu.washington.kpham97.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class marvOverview extends AppCompatActivity {

    int total;
    int correctNum;
    Button beginBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marv_overview);

        total = 0;
        correctNum = 0;

        beginBut = (Button) findViewById(R.id.begin);
        beginBut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), marv1.class);
                i.putExtra("total", total);
                i.putExtra("correctNum", correctNum);
                startActivity(i);
            }
        });

    }
}
