package edu.washington.kpham97.quizdroid;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Kito Pham on 2/27/2017.
 */

public class downloadservice extends IntentService {


    Handler mHandler;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.

     */
    public downloadservice() {
        super("downloadservice");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        QuizApp.downloadsuccess = false;
        String url = intent.getStringExtra("url");

        Log.i("Operation", "onReceive: url is " + url);


        BufferedReader input = null;
        PrintWriter output = null;
        try {
            Log.i("Operation", "writing file");
            URL jsonurl = new URL(url);
            input = new BufferedReader(new InputStreamReader(jsonurl.openStream()));
            output = new PrintWriter(this.getFilesDir() + "/quizdata.json");

            String string;
            while ((string = input.readLine()) != null) {
                output.write(string);
            }
            QuizApp.downloadsuccess = true;

        } catch (MalformedURLException e) {
            Log.i("Operation", "url error");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null){
                    output.close();
                }
            } catch (Exception e) {
            }
        }

        if(QuizApp.downloadsuccess) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Download complete", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            MainActivity.exitApp();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
    }
}