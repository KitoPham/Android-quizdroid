package edu.washington.kpham97.quizdroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * Created by Kito Pham on 2/17/2017.
 */

public class settingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private receiver download = new receiver();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_screen);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = super.onCreateView(inflater,container,savedInstanceState);
        view.setBackgroundColor(getResources().getColor(android.R.color.white));
        return view;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Toast.makeText(getActivity().getApplicationContext(),"Will attempt to download from "+sharedPreferences.getString("url", "http://tednewardsandbox.site44.com/questions.json") +" in " + sharedPreferences.getString("downloadtime", "5")+ " minutes.", Toast.LENGTH_LONG).show();

        download.cancelDownload(getActivity().getApplicationContext());
        download.setDownload(getActivity().getApplicationContext());
    }
    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
