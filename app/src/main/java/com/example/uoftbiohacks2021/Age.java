package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.uoftbiohacks2021.logic.User;

public class Age extends AppCompatActivity {

    private Spinner age;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        String[] arraySpinner = new String[] {
                "0-17", "18-29", "30-39", "40-49", "50-64", "65-74", "75-84", "Over 85"
        };
        age = (Spinner) findViewById(R.id.agespinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age.setAdapter(adapter);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
    }

    public void next(View view) {
        int select = age.getSelectedItemPosition();
        switch (select) {
            case 0:
                currentUser.updateRiskFactor(3);
                break;
            case 1:
                currentUser.updateRiskFactor(4);
                break;
            case 2:
                currentUser.updateRiskFactor(5);
                break;
            case 3:
                currentUser.updateRiskFactor(7);
                break;
            case 4:
                currentUser.updateRiskFactor(9);
                break;
            case 5:
            case 7:
            case 6:
                currentUser.updateRiskFactor(10);
                break;
        }
        Intent intent = new Intent(this, Exercise.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }
}
// Please set the risk values according to this
// 0 - 17: 3
//18 - 29: 4
//30 - 39: 5
//40 - 49: 7
//50 - 64: 9
//65 - 74: 10
//75 - 84: 10
//Over 85: 10