package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.uoftbiohacks2021.logic.User;
import com.example.uoftbiohacks2021.logic.UserWriter;

public class additional_information extends AppCompatActivity {

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());

    }


    @Override
    public boolean onSupportNavigateUp() {
        Intent back = new Intent(this, MainPage.class);
        back.putExtra("currentUser", currentUser);
        startActivity(back);
        return true;
    }
}