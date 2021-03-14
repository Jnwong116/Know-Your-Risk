package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uoftbiohacks2021.logic.LoginValidator;
import com.example.uoftbiohacks2021.logic.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Launch Registration page
     */
    public void registerScreen(View view) {
        Intent intent = new Intent(this, registration.class);
        startActivity(intent);
    }

    /**
     * Login
     */
    public void loginValidation(View view) {
        EditText usernameField = findViewById(R.id.editTextPersonName);
        EditText passwordField = findViewById(R.id.editTextPassword);

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        LoginValidator loginValidator = new LoginValidator();
        User currentUser = loginValidator.validate(username, password, getApplicationContext());

        if(currentUser == null) {
            //Incorrect login credentials
            Toast.makeText(getApplicationContext(), "Your login credentials are incorrect", Toast.LENGTH_SHORT).show();
        }
        else {
            //Successful login
            currentUser.setContext(getApplicationContext());
            Intent intent = new Intent(this, MainPage.class);
            intent.putExtra("currentUser", currentUser);
            startActivity(intent);
        }
    }
}