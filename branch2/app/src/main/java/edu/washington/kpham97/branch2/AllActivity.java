package edu.washington.kpham97.branch2;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;



public class AllActivity extends AppCompatActivity {

    private static int total;
    private static String topic;
    private static int count;
    private static int correctNum;
    private static FragmentManager fragManager;

    private static String yourAnswer;
    private static String correctAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        fragManager = getSupportFragmentManager();

        Intent nIntent;
        nIntent = getIntent();
        total = nIntent.getIntExtra("total",0);
        topic = nIntent.getStringExtra("topic");

        if(savedInstanceState == null) {
            count = 0;
            correctNum = 0;
        }



        if (topic.equals("Math")){
            MathOverviewFragment fragment = new MathOverviewFragment();
            fragManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        } else if (topic.equals("Physics")){
            PhysicsOverviewFragment fragment = new PhysicsOverviewFragment();
            fragManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        } else if (topic.equals("Marvel")){
            MarvelOverviewFragment fragment = new MarvelOverviewFragment();
            fragManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        } else if (topic.equals("Same")){
            SameOverviewFragment fragment = new SameOverviewFragment();
            fragManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        }


    }

    public static void changeToQuestion(){
        count++;
        Log.i("Variable Count", "" + count );
        Log.i("Variable Topic", "" + topic );

        if (topic.equals("Math")){
            if(count == 1){
                math1fragment fragment = new math1fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }else if (count == 2){
                math2fragment fragment = new math2fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }else if (count == 3) {
                math3fragment fragment = new math3fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (count == 4) {
                math4fragment fragment = new math4fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (count == 5) {
                math5fragment fragment = new math5fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        } else if (topic.equals("Physics")){
            if(count == 1){
                phy1fragment fragment = new phy1fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }else if (count == 2){
                phy2fragment fragment = new phy2fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }else if (count == 3) {
                phy3fragment fragment = new phy3fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        }  else if (topic.equals("Marvel")) {
            if (count == 1) {
                marvel1fragment fragment = new marvel1fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (count == 2) {
                marvel2fragment fragment = new marvel2fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        }  else if (topic.equals("Same")) {
            if (count == 1) {
                same1fragment fragment = new same1fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (count == 2) {
                same2fragment fragment = new same2fragment();
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
    public static void changeToAnswer(boolean correct, String yourAnswer, String correctAnswer){
        if (correct){
            correctNum++;
        }
        AllActivity.yourAnswer = yourAnswer;
        AllActivity.correctAnswer = correctAnswer;

        AnswerFragment fragment = new AnswerFragment();

        Bundle args = new Bundle();
        args.putInt("correct",correctNum);
        args.putInt("total", count);
        args.putString("yourAnswer", yourAnswer);
        args.putString("correctAnswer", correctAnswer);
        args.putBoolean("finalQuestion", count == total);
        fragment.setArguments(args);

        fragManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();

    }
}
