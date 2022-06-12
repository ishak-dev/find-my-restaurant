package com.example.restaurant;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Admin_Restaurant_Details extends AppCompatActivity {



    private EditText titleInput,shortDescriptionInput,descriptionInput,reviewInput, expensiveInput,locationInput,webUrlInput;
    Button add_btn,delete_btn,update_btn;
    private ImageView image;
    private long id;
    private Uri imageData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_restaurant_details);

        image = findViewById(R.id.set_image);
        titleInput = findViewById(R.id.set_title);
        shortDescriptionInput = findViewById(R.id.set_short_desc);
        descriptionInput = findViewById(R.id.set_description);
        reviewInput = findViewById(R.id.set_review);
        expensiveInput = findViewById(R.id.set_expensive);
        locationInput = findViewById(R.id.set_location);
        webUrlInput = findViewById(R.id.set_web_uri);

        add_btn = findViewById(R.id.add_btn);
        delete_btn = findViewById(R.id.delete_btn);
        update_btn = findViewById(R.id.update_btn);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            id = extras.getLong(AdminDashboard.EXTRA_RESTAURANT_ID);
            RestaurantModel restaurant = AppDatabase.getInstance(this).restaurantDao().getById(id);


            imageData = Uri.parse(restaurant.getImageResId());
            image.setImageURI(imageData);
            titleInput.setText(restaurant.getTitle());
            shortDescriptionInput.setText(restaurant.getDescription());
            descriptionInput.setText(restaurant.getLongDescription());
            reviewInput.setText(restaurant.getReview());
            expensiveInput.setText(restaurant.getExpensive());
            locationInput.setText(restaurant.getLocation());
            webUrlInput.setText(restaurant.getUrl());
            add_btn.setVisibility(View.GONE);
        }
        else{
        delete_btn.setVisibility(View.GONE);
        update_btn.setVisibility(View.GONE);
        }

    }

    public void onSave(View view){
        RestaurantModel restaurant = new RestaurantModel(
                imageData.toString(),
                titleInput.getText().toString(),
                shortDescriptionInput.getText().toString(),
                descriptionInput.getText().toString(),
                reviewInput.getText().toString(),
                expensiveInput.getText().toString(),
                locationInput.getText().toString(),
                webUrlInput.getText().toString()
        );
        AppDatabase.getInstance(this).restaurantDao().add(restaurant);
        Intent intent =  new Intent(this,AdminDashboard.class);
        startActivity(intent);
    }

    public void onDelete(View view){
        AppDatabase.getInstance(this).restaurantDao().deleteById(id);
        Intent intent = new Intent(this,AdminDashboard.class);
        startActivity(intent);
    }

    public void onUpdate(View view){
        AppDatabase.getInstance(this).restaurantDao().updateRest(
                id,
                imageData.toString(),
                titleInput.getText().toString(),
                shortDescriptionInput.getText().toString(),
                descriptionInput.getText().toString(),
                reviewInput.getText().toString(),
                expensiveInput.getText().toString(),
                locationInput.getText().toString(),
                webUrlInput.getText().toString()
                );
        Intent intent = new Intent(this,AdminDashboard.class);
        startActivity(intent);
        Toast.makeText(this, "Successfull updated", Toast.LENGTH_SHORT).show();
    }



    private final int GALLERY_REQ_CODE=1000;
    public void uploadPicture(View view){
        Intent iGallery = new Intent(Intent.ACTION_PICK);
        iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(iGallery, GALLERY_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                //for gallery
                image.setImageURI(data.getData());
                imageData = data.getData();
            }
        }
    }
}