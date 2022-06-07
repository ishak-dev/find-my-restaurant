package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {




    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        bottomNavigationView.setOnItemSelectedListener(onItemSelectedListener);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager(viewPager);


    }

    private void setUpViewPager(ViewPager viewPager){
        NavigationMenuAdapter navigationMenuAdapter = new NavigationMenuAdapter(getSupportFragmentManager());
        navigationMenuAdapter.addFragment(new HomeFragment());
        navigationMenuAdapter.addFragment(new NotificationFragment());
        navigationMenuAdapter.addFragment(new ContactFragment());
        navigationMenuAdapter.addFragment(new ProfileFragment());
        viewPager.setAdapter(navigationMenuAdapter);
    }

    private NavigationBarView.OnItemSelectedListener onItemSelectedListener  = (item)->{
        switch(item.getItemId()){
            case R.id.home:
                viewPager.setCurrentItem(0);
                return true;
            case R.id.notification:
                viewPager.setCurrentItem(1);
                return true;
            case R.id.contactus:
                viewPager.setCurrentItem(2);
                return true;
            case R.id.profile:
                viewPager.setCurrentItem(3);
                return true;
        }
        return false;
    };



}