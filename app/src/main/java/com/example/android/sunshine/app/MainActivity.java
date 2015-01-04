package com.example.android.sunshine.app;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
*/

public class MainActivity extends Activity {

    Handler mUiHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.e("test", "msg.what = "+msg.what);
            if(mContext != null){
                Log.e("test", "Context is not null");
            }else if(mContext == null){
                Log.e("test", "Context is null");
            }
        }
    };

    private Context mContext;
    private int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("test", "onCreate");
        setContentView(R.layout.activity_main);

        mContext = this;
        a = 5000;

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }

        new JobThread(mUiHandler).start();

    }

    class JobThread extends Thread{
        private Handler mUiHandler;
        public JobThread(Handler handler){
            mUiHandler = handler;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(a);    //어떤 작업
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message msg = new Message();
            msg.what = 1;

            mUiHandler.sendMessageDelayed(msg, 10000);
            mUiHandler.removeMessages(1);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("asdfsd", "ASDFSda");
        Log.e("test", "onSaveInstanceState");
        for (String key : outState.keySet()){
            Log.e("test", key+"/"+outState.getString(key));
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("test", "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e("test", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("test", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e("test", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e("test", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("test", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContext = null;
        Log.e("test", "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
