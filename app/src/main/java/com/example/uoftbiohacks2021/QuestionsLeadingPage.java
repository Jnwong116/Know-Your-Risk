package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.uoftbiohacks2021.logic.User;

public class QuestionsLeadingPage extends AppCompatActivity {

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_leading_page);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
    }

    public void next(View view) {
        Intent intent = new Intent(this, Age.class);
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }
}