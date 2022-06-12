package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantDetails extends AppCompatActivity {

    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView longDescription;
    private TextView expensive;
    private TextView review;
    private String urlText;
    private String locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        imageView = findViewById(R.id.restaurant_image_details);
        title = findViewById(R.id.restaurant_title_details);
        description = findViewById(R.id.restaurant_description_details);
        longDescription = findViewById(R.id.restaurant_long_description_details);
        expensive = findViewById(R.id.restaurant_expensive_details);
        review = findViewById(R.id.restaurant_review_details);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            long getId = extras.getLong(HomeFragment.EXTRA_RESTAURANT_ID);
            RestaurantModel restaurant = AppDatabase.getInstance(this).restaurantDao().getById(getId);
            imageView.setImageURI(Uri.parse(restaurant.getImageResId()));
            title.setText(restaurant.getTitle());
            description.setText(restaurant.getDescription());
            longDescription.setText(restaurant.getLongDescription());
            expensive.setText(restaurant.getExpensive());
            review.setText(restaurant.getReview());

            urlText = restaurant.getUrl();
            locationText = restaurant.getLocation();

        }
    }

    public void goToUrl(View view){

        Uri uri  = Uri.parse("http://"+urlText);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "Cannot perform this action", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToLocation(View view){
        Uri uri = Uri.parse("geo:0,0?q="+locationText);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "Cannot perform this action", Toast.LENGTH_SHORT).show();
        }
    }
}