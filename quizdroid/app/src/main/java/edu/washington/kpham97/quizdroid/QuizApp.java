package edu.washington.kpham97.quizdroid;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kito Pham on 2/16/2017.
 */

public class QuizApp extends Application {
    private static QuizApp singleton;
    static TopicRepository data;
    private static int topic;
    static int correctQuestions;
    static int count;
    static int lastanswer;
    static boolean downloadsuccess;

    public static QuizApp getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        fillRepo();

        Log.i("LAUNCH", "onCreate: Instance Created");
        reset();
    }

    public static TopicObject getData(){
      return data.topics[topic];
    }
    public static int getSize(){
        return data.topiccount;
    }

    public static void setTopic(int n){
        topic = n;
    }

    public static void reset(){
        correctQuestions = 0;
        count = 0;
        lastanswer = 0;
    }

    public static void fillRepo(){
        try {
            File file = new File("data/questions.json");
            InputStream in = new FileInputStream(file);
            data = new TopicRepository(in);
        } catch (IOException e) {
            Log.i("WARNING", "STUFF NOT WORKING");;
        }
    }
    @Override
    public void onLowMemory(){
        super.onLowMemory();
    }
    @Override
    public void onTerminate(){
        super.onTerminate();
    }
}
