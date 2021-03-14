package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.uoftbiohacks2021.logic.User;
import com.example.uoftbiohacks2021.logic.UserWriter;

public class MainPage extends AppCompatActivity {
    private User currentUser;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
        UserWriter userWriter = new UserWriter();
        currentUser.addObserver(userWriter);

        this.title = findViewById(R.id.WelcomeMessage);
        this.title.setText("Hello " + currentUser.getUsername() + "! Here are some recommended activities. Be sure to let us know if there are any changes to your health status.");
    }

    public void moreInfo(View view) {
        Intent intent = new Intent(this, additional_information.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }

    /*public void updateHealth(View view) {
        Intent intent = new Intent(this, );
        startActivity(intent);
    }*/
}