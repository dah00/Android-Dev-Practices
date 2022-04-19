package edu.sju.android.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
    Intents = is an object that provides runtime binding between separate compnents, sush as two activities
    It represents an app's "intent to do something"
    You can use intents for a wide variety of tasks, but in this lesson, your intent starts another activity
 */

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        go = findViewById(R.id.button);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = name.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("keyword", userName);
                startActivity(intent);


            }
        });
    }
}