package edu.sju.android.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;

    final int ACTIVITY3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name = etName.getText().toString().trim();
                    // Go from MainActivity to Activity to.
                    // Explicit because we know where we want to go
                    // we explicitly specify the destination activity
                    Intent intent = new Intent(MainActivity.this, edu.sju.android.explicitintent.Activity2.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, edu.sju.android.explicitintent.Activity3.class);
                startActivityForResult(intent, ACTIVITY3);  // Needs to be updated
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY3){
            if (resultCode == RESULT_OK){
                tvResults.setText(data.getStringExtra("surname"));
            }

            // In case the user leave the text field blank and use the return button to come back
            // the resultCode will be equal to RESULT_CANCELED
            if (resultCode == RESULT_CANCELED){
                tvResults.setText("No data received!");
            }
        }
    }
}