package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText emailInput, passwordInput;
    public static final String EXTRA_USER_EMAIL = "Login/EXTRA_USER_EMAIL";
    public static final String EXTRA_USER_USERNAME = "Login/EXTRA_USER_USERNAME";
    String getUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.login_email);
        passwordInput = findViewById(R.id.login_password);


        Intent intent = getIntent();
    }

    public void openSignup(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void goToHomePage(View view){

        String getEmail = emailInput.getText().toString();
        String getPassword = passwordInput.getText().toString();
        Signup email = AppDatabase.getInstance(this).signupDao().getUserByEmail(getEmail);
        Signup password = AppDatabase.getInstance(this).signupDao().getUserByPassword(getEmail,getPassword);

        if (email != null){
            if(password != null){
                if(email.getEmail().equals("admin") || email.getPassword().equals("admin")){
                    Intent intent = new Intent(this, AdminDashboard.class);
                    startActivity(intent);
                }
                else{
                    getUsername = email.getUsername();
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra(EXTRA_USER_EMAIL,getEmail);
                intent.putExtra(EXTRA_USER_USERNAME,getUsername.toString());
                    Toast.makeText(this, "Welcome "+getUsername, Toast.LENGTH_SHORT).show();
                startActivity(intent);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("string_id", getUsername); //InputString: from the EditTexteditor.commit();

                }
            }else{
                Toast.makeText(this, "Password wrong", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show();
        }
    }

}