package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {



    private EditText nameInput, emailInput, usernameInput, passwordInput, dayInput, monthInput, yearInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameInput = findViewById(R.id.editText_setName);
        emailInput = findViewById(R.id.login_email);
        usernameInput = findViewById(R.id.login_password);
        passwordInput = findViewById(R.id.editText_setPassword);
        dayInput = findViewById(R.id.editText_setDay);
        monthInput = findViewById(R.id.editText_setMonth);
        yearInput = findViewById(R.id.editText_setYear);
    }

    public void onSignUp(View view){
        Signup signup = new Signup(nameInput.getText().toString(),
                emailInput.getText().toString(),
                usernameInput.getText().toString(),
                passwordInput.getText().toString(),
                dayInput.getText().toString(),
                monthInput.getText().toString(),
                yearInput.getText().toString()
        );
        String getEmail = emailInput.getText().toString();
        Signup email = AppDatabase.getInstance(this).signupDao().getUserByEmail(getEmail);
        if(email==null){
            AppDatabase.getInstance(this).signupDao().add(signup);
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "User exist", Toast.LENGTH_SHORT).show();
        }



    }

    public void OnLogIn(View view){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

}