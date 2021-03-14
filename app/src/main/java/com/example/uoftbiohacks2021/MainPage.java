package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.uoftbiohacks2021.logic.User;
import com.example.uoftbiohacks2021.logic.UserWriter;

import org.w3c.dom.Text;

public class MainPage extends AppCompatActivity {
    private User currentUser;
    TextView title;
    private int riskFactor;
    TextView recommendedActivities;
    TextView avoidedActivities;

    private String lowRisk = "Exercising individually outdoors\n" +
            "Getting restaurant takeout\n" +
            "Individual and socially-distanced sports\n";
    private String medRisk = "Shopping (groceries, leisure)\n" +
            "Going to the doctors\n" +
            "Eating outdoors at a restaurant\n" +
            "Walking in a crowded area\n";
    private String highRisk = "Social gatherings (movie theatres, amusement park, weddings, religious service)\n" +
            "Eating indoors at a restaurant\n" +
            "Travelling in public transport (air, ground, water)\n" +
            "Working out at a gym \n" +
            "Interacting with people closely outside of immediate family\n" +
            "Playing close-contact sports (football, basketball)\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
        UserWriter userWriter = new UserWriter();
        currentUser.addObserver(userWriter);

        this.riskFactor = currentUser.getRiskFactor();
        String risk;
        String rec;
        String avoid;

        if (riskFactor < 8) {
            risk = "low risk";
            rec = lowRisk + medRisk;
            avoid = highRisk;
        }
        else if (riskFactor > 20) {
            risk = "high risk";
            rec = "";
            avoid = lowRisk + medRisk + highRisk;
        }
        else {
            risk = "medium risk";
            rec = lowRisk;
            avoid = highRisk;
        }

        this.title = findViewById(R.id.WelcomeMessage);
        this.title.setText("Hello " + currentUser.getUsername() + "! Based on your current health information you are at " + risk + " for COVID-19 complications. Find out more on how you can protect yourself here and checkout some recommended activities. Be sure to let us know if there are any changes to your health status.");
        this.recommendedActivities = findViewById(R.id.textView6);
        this.avoidedActivities = findViewById(R.id.textView7);
        this.recommendedActivities.setText(rec);
        this.avoidedActivities.setText(avoid);

    }

    public void moreInfo(View view) {
        Intent intent = new Intent(this, additional_information.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }

    public void updateHealth(View view) {
        Intent intent = new Intent(this, Age.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }
}