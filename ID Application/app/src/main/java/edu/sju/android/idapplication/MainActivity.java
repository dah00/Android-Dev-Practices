package edu.sju.android.idapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = etID.getText().toString().trim(); // trim() takes away any white space
                String dob = idNumber.substring(0, 6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if (gender<5)
                    sGender = "Female";
                else
                    sGender = "Male";

                String sNationality;
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                if (nationality == 0)
                    sNationality = "SA Citizen";
                else
                    sNationality = "Permanent Resident";

                tvResults.setText("Date of Birth: " + dob + "\n" +
                        "Gender: " + sGender + "\n" + "Nationality: " + sNationality);
                tvResults.setVisibility(View.VISIBLE);
            }
        });

    }
}