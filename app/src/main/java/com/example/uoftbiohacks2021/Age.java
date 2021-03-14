package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Age extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        String[] arraySpinner = new String[] {
                "0-17", "18-29", "30-39", "40-49", "50-64", "65-74", "75-84", "Over 85"
        };
        Spinner s = (Spinner) findViewById(R.id.agespinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
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