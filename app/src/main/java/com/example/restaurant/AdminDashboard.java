package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AdminDashboard extends AppCompatActivity {

    public static final String EXTRA_RESTAURANT_ID = "AdminDashboard/EXTRA_RESTAURANT_ID";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        getPermission();

        listView = findViewById(R.id.list_view_admin);
        setUpListAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                long resId = adapterView.getItemIdAtPosition(i);
                Intent intent = new Intent(AdminDashboard.this, Admin_Restaurant_Details.class);
                intent.putExtra(EXTRA_RESTAURANT_ID,resId);
                startActivity(intent);
            }
        });

    }

    public void setUpListAdapter(){
        List<RestaurantModel> restaurants = AppDatabase.getInstance(this).restaurantDao().getAll();

        RestaurantListViewAdapter adapter = new RestaurantListViewAdapter(restaurants, this);
        listView.setAdapter(adapter);

    }

    public void onAddClick(View view){
        Intent intent = new Intent(this, Admin_Restaurant_Details.class);
        startActivity(intent);
    }

    public void onNotificationClick(View view){
        Intent intent = new Intent(this, Admin_Notificaiton_Activity.class);
        startActivity(intent);
    }

    public void onMessageClick(View view){
        Intent intent = new Intent(this, Admin_Message.class);
        startActivity(intent);
    }

    public void getPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},123);
    }


}