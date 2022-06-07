package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_slider);
        bottomNavigationView.setOnItemSelectedListener(onItemSelectedListener);
        viewPager = findViewById(R.id.viewPager2);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Slide1Fragment());
        viewPagerAdapter.addFragment(new Slide2Fragment());
        viewPagerAdapter.addFragment(new Slide3Fragment());
        viewPagerAdapter.addFragment(new Slide4Fragment());
        viewPager.setAdapter(viewPagerAdapter);
    }

    private NavigationBarView.OnItemSelectedListener onItemSelectedListener = (item) ->{
        switch(item.getItemId()){
            case R.id.slide1:
                viewPager.setCurrentItem(0);
                return true;
            case R.id.slide2:
                viewPager.setCurrentItem(1);
                return true;
            case R.id.slide3:
                viewPager.setCurrentItem(2);
                return true;
            case R.id.slide4:
                viewPager.setCurrentItem(3);
                return true;
        }
        return false;
    };

    public void openLogin(View view){
        Intent intent =  new Intent(this,Login.class);
        startActivity(intent);
    }




}