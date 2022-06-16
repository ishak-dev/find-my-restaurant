package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RestaurantDetails extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView longDescription;
    private TextView expensive;
    private TextView review;
    private String urlText;
    private String locationText;
    private ListView listView;

    long getId;

    public static final String EXTRA_RESTAURANT_ID = "RestaurantDetails/EXTRA_RESTAURANT_ID";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);

        imageView = findViewById(R.id.restaurant_image_details);
        title = findViewById(R.id.restaurant_title_details);
        description = findViewById(R.id.restaurant_description_details);
        longDescription = findViewById(R.id.restaurant_long_description_details);
        expensive = findViewById(R.id.restaurant_expensive_details);
        review = findViewById(R.id.restaurant_review_details);
        listView = findViewById(R.id.list_view_reviews);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            getId = extras.getLong(HomeFragment.EXTRA_RESTAURANT_ID);
            RestaurantModel restaurant = AppDatabase.getInstance(this).restaurantDao().getById(getId);
            imageView.setImageURI(Uri.parse(restaurant.getImageResId()));
            title.setText(restaurant.getTitle());
            description.setText(restaurant.getDescription());
            longDescription.setText(restaurant.getLongDescription());
            expensive.setText(restaurant.getExpensive());
            review.setText(restaurant.getReview());

            urlText = restaurant.getUrl();
            locationText = restaurant.getLocation();

            setUpListAdapter();

        }


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefreshLayout.setRefreshing(false);
                setUpListAdapter();
            }
        });
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

    public void addReview(View view){
        Intent intent = new Intent(this, UserAddReview.class);
        intent.putExtra(EXTRA_RESTAURANT_ID,getId);

        startActivity(intent);
    }


    public void setUpListAdapter(){

        List<Review> reviewList = AppDatabase.getInstance(this).reviewDao().listAllRew(getId);
        ReviewsListViewAdapter adapter = new ReviewsListViewAdapter(reviewList,this);
        listView.setAdapter(adapter);
    }
}