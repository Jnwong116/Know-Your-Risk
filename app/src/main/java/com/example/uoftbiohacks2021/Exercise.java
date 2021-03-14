package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Spinner;

import android.widget.Toast;

import com.example.uoftbiohacks2021.logic.User;


public class Exercise extends AppCompatActivity {

    private User currentUser;
    private Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        String[] arraySpinner = new String[] {
                "Extremely Sedentary", "Sedentary", "Average", "Active", "Extremely Active"
        };
        s = (Spinner) findViewById(R.id.Exercisespinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
    }

    public void next(View view) {
        int select = s.getSelectedItemPosition();
        switch (select) {
            case 0:
                currentUser.updateRiskFactor(5);
                break;
            case 1:
                currentUser.updateRiskFactor(4);
                break;
            case 2:
                currentUser.updateRiskFactor(3);
                break;
            case 3:
                currentUser.updateRiskFactor(2);
                break;
            case 4:
                currentUser.updateRiskFactor(1);
                break;
        }

        Intent intent = new Intent(this, RiskFactorQuestions.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }
}
// add what each of the spinner options do, from 5 to 1