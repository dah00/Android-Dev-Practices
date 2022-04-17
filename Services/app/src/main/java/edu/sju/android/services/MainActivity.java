package edu.sju.android.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
    A service is an application component that can perform long-running operations in the background
    Services do not provide a user interface
    Another application component can start a service

    3 types of services
         - Foreground services: user should get notify about this service
         - Background services: user doesn't get notification, users might not even know
         - Bound services: Dependent on a component that calls itself

    2 Service classes
        - Service Classes: takes on the whole class on its own. It uses the app's main thread (slows down the app)
        - Intent Service Classes: Uses its own thread (doesn't slow down the app)
 */

public class MainActivity extends AppCompatActivity {

    Button buttonStart;
    Button buttonStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ServicesExample.class);
                startService(i);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ServicesExample.class);
                stopService(i);
            }
        });
    }
}