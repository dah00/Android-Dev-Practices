package edu.sju.android.customeview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.sju.android.customeview.vews.CustomView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomView customView = new CustomView(this );
    }
}