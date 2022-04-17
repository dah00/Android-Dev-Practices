package edu.sju.android.broadcastreveiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/*
    These broadcast messages are sent when an event of interest occurs
    For example: System Boots, Device starts charging, when the charge of device is low, and etc.

    When a broadcast is sent, the system automatically routes broadcasts to apps that
    have subscribed to receive that particular type of broadcast
 */

public class MainActivity extends AppCompatActivity {

    BroadcastExample br = new BroadcastExample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(br);
    }
}