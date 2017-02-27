package edu.washington.kpham97.quizdroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kito Pham on 2/26/2017.
 */

public class receiver extends WakefulBroadcastReceiver {

    private AlarmManager manager;
    private PendingIntent alarmIntent;
    private SharedPreferences pref;

    public receiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        String url = pref.getString("url", "http://tednewardsandbox.site44.com/questions.json");
        Intent service = new Intent(context, downloadservice.class);
        service.putExtra("url", url);
        Toast.makeText(context, "Attempting a download from " + url, Toast.LENGTH_SHORT).show();
        context.startService(service);
        if(QuizApp.downloadsuccess) {
            Toast.makeText(context, "Download complete", Toast.LENGTH_LONG).show();
        } else {
            MainActivity.exit();
        }
        QuizApp.fillRepo();
    }

    public void setDownload(Context context) {
        Log.i("Operation", "setDownload: Started ");
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        int interval = Integer.parseInt(pref.getString("downloadtime", "5"));
        Log.i("Operation", "setDownload: interval is " + interval);

        manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, receiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        manager.setRepeating(AlarmManager.RTC_WAKEUP, interval * 60 * 1000, interval * 60 * 1000, alarmIntent);

    }

    public void cancelDownload(Context context) {
        if (manager != null) {
            manager.cancel(alarmIntent);
        }
    }
}

