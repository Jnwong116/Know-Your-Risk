package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.uoftbiohacks2021.logic.User;

import org.w3c.dom.Text;

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
}