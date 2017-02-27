package edu.washington.kpham97.quizdroid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{

    private static RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private static RecyclerView.LayoutManager mLayoutManager;
    receiver download = new receiver();
    private static Activity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        download.setDownload(this);
        change("start");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new settingsFragment())
                        .addToBackStack("Back")
                        .commit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public static void exit(){
        new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.myDialog))
                .setMessage("Download Unsuccessful: Would you like to quit and try again later?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Stop the activity
                        activity.finish();
                        System.exit(0);
                    }

                })
                .setNegativeButton("No", null)
                .show();
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

    public void connectivity(){
        boolean airplanemode = isAirplaneModeOn(this);
        if(!airplanemode){
            new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.myDialog))
                    .setMessage("Airplane mode is on. Would you like to turn it off?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS));
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

        }

        ConnectivityManager connect = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = connect.getActiveNetworkInfo();

        if(network == null || network.isConnectedOrConnecting()){
            new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.myDialog))
                    .setMessage("Error: No Network")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            activity.finish();
                            System.exit(0);
                        }
                    })
                    .show();
        }


    }

    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isAirplaneModeOn(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.System.getInt(context.getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0) != 0;
        } else {
            return Settings.Global.getInt(context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
        }
    }

}
