package edu.sju.android.sharedpreferencessavingdatalocalmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/*
    Shared Preference allow you to save and retrieve data in the form of key, value pair

    Shared Preferences are used to save and retrieve the primitive data types (integer, float, boolean, etc.) data

    The Shared Preferences file is managed by an android framework and
    it can be accessed anywhere within the app to read and write data into the file

 */

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText userMessage;
    Button counter;
    CheckBox remember;

    int count = 0;
    String name;
    String message;
    boolean isChecked;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.editTextName);
        userMessage = findViewById(R.id.editTextMessage);
        counter = findViewById(R.id.button);
        remember = findViewById(R.id.checkBox);

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counter.setText("" + count);
            }
        });

        retrieveData();

    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }


    public void saveData(){
        // Context.MODE_PRIVATE -> save data within the app only, but not from other apps
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        name = userName.getText().toString();
        message = userMessage.getText().toString();
        if (remember.isChecked())
            isChecked = true;
        else
            isChecked = false;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key name", name);
        editor.putString("key message", message);
        editor.putInt("key count", count);
        editor.putBoolean("key remember", isChecked);
        editor.commit();

        Toast.makeText(this, "Your data is saved", Toast.LENGTH_SHORT).show();
    }

    public void retrieveData(){
        sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE);
        name = sharedPreferences.getString("key name", null);
        message = sharedPreferences.getString("key message", null);
        count = sharedPreferences.getInt("key count", 0);
        isChecked = sharedPreferences.getBoolean("key remember", false);

        userName.setText(name);
        userMessage.setText(message);
        counter.setText("" + count);
        if (isChecked)
            remember.setChecked(true);
        else
            remember.setChecked(false);

    }
}