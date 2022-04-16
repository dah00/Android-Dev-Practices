package edu.sju.android.applicatonlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button1;
    Button button2;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                textView.setText("" + counter);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);
            }
        });


        Log.d("Message", "First Activity onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message", "First Activity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Message", "First Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Message", "First Activity onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Message", "First Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "First Activity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message", "First Activity onRestart");
    }
}