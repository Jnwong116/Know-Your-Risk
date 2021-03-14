package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uoftbiohacks2021.logic.User;
import com.example.uoftbiohacks2021.logic.UserManager;

import java.io.IOException;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void registerUser(View view) throws IOException {
        UserManager userManager = new UserManager();
        String pattern = "^[A-Za-z0-9]+$";
        EditText usernameField = (EditText) findViewById(R.id.registerUsername);
        EditText passwordField = (EditText) findViewById(R.id.registerPassword);

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        if (username.length() == 0) {
            Toast.makeText(getApplicationContext(), "Username cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if (password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(!username.matches(pattern)){
            Toast.makeText(getApplicationContext(), username, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Username may only contain letters and numbers", Toast.LENGTH_SHORT).show();
        }
        else {
            Object[] res = userManager.createUser(username, password, getApplicationContext());
            if (!(boolean) res[1]) {
                Toast.makeText(getApplicationContext(), "Thjs username is already in use", Toast.LENGTH_SHORT).show();
            }
            else {
                User currentUser = (User) res[0];
                currentUser.setContext(getApplicationContext());
                Intent intent = new Intent(this, QuestionsLeadingPage.class);
                intent.putExtra("currentUser", currentUser);
                startActivity(intent);
            }
        }



    }
}