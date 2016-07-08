package com.nisum.activitiesandcommunication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by NIS1175m on 7/8/16.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyReceiver","onReceive");
        Bundle b = intent.getExtras();
        Log.d("MyReceiver","onReceive Data "+b.getString("mycustomedata"));
    }
}
