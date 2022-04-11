package edu.sju.android.recyclerviewpart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private ArrayList<String> countryNameList = new ArrayList<>();
    private ArrayList<String> detailsLis = new ArrayList<>();
    private ArrayList<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryNameList.add("United Kingdom");
        countryNameList.add("Australia");
        countryNameList.add("United States of America");

        detailsLis.add("This is the United Kingdom flag");
        detailsLis.add("This is the Australia flag");
        detailsLis.add("This is the USA flag");

        imageList.add(R.drawable.uk);
        imageList.add(R.drawable.australia);
        imageList.add(R.drawable.usa);

        adapter = new RecyclerAdapter(countryNameList, detailsLis, imageList, MainActivity.this);

        recyclerView.setAdapter(adapter);

    }
}