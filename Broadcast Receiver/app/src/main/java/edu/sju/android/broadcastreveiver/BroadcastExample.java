package edu.sju.android.broadcastreveiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isPlaneMode = intent.getBooleanExtra("state", false);

        if (isPlaneMode){
            Toast.makeText(context, "Device is Airplane mode", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Device is not in airplane mode", Toast.LENGTH_SHORT).show();
        }


    }
}
