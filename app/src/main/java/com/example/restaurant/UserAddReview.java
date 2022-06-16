package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserAddReview extends AppCompatActivity {
    EditText getReview,getUsername;
    String username;
    long getId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_review);
        getReview = findViewById(R.id.user_reviewText);

        Bundle extras =  getIntent().getExtras();
        getId = extras.getLong(RestaurantDetails.EXTRA_RESTAURANT_ID);
        getUsername = findViewById(R.id.user_username);
        //username = getIntent().getStringExtra("EXTRA_USER_USERNAME");
        username= "user";
       // SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //String data = prefs.getString("string_id", "no id"); //no id: default value
        //username = data;
    }

    public void add(View view){

        Review review = new Review(
                username,
                getReview.getText().toString(),
                getId
        );

        AppDatabase.getInstance(this).reviewDao().add(review);
        Toast.makeText(this, "Review added", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}