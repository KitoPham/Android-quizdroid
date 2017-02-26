package edu.washington.kpham97.branch4;

import android.app.Application;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Kito Pham on 2/16/2017.
 */

public class QuizApp extends Application {
    private static QuizApp singleton;
    private static TopicRepository data;
    private static int topic;
    static int correctQuestions;
    static int count;
    static int lastanswer;

    public static QuizApp getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        try {
            data = new TopicRepository();
        } catch (IOException e) {
            Log.i("WARNING", "STUFF NOT WORKING");;
        }

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
    @Override
    public void onLowMemory(){
        super.onLowMemory();
    }
    @Override
    public void onTerminate(){
        super.onTerminate();
    }
}
