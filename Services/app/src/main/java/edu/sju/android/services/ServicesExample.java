package edu.sju.android.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServicesExample extends IntentService {

    public ServicesExample() {
        super("name");
    }

    /*    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }*/

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("Service", "onHandleIntent method worked");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Service", "Service is created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service", "Service is started");
        //stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service", "Service is stopped");
    }
}
