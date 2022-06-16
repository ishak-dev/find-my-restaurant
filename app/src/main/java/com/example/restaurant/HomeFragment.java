package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ListView listView;
    public static final String EXTRA_RESTAURANT_ID = "HomeFragment/EXTRA_RESTAURANT_ID";
    public static final String EXTRA_USER_USERNAME = "HomeFragment/EXTRA_USER_USERNAME";
    int numberOfRest;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.home_fragment, viewGroup, false);
        listView =(ListView) view.findViewById(R.id.list_view);


        setUpListAdapter();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                long id = adapterView.getItemIdAtPosition(i);
                Intent intent = new Intent(getActivity(), RestaurantDetails.class);
                intent.putExtra(EXTRA_RESTAURANT_ID,id);

                startActivity(intent);
            }
        });

        TextView restaurantNumber = view.findViewById(R.id.restaurantNumber);
        restaurantNumber.setText(numberOfRest+" ");
        return view;
    }




    public void setUpListAdapter(){
        List<RestaurantModel> restaurants = AppDatabase.getInstance(getActivity()).restaurantDao().getAll();
        numberOfRest = restaurants.size();
        RestaurantListViewAdapter adapter = new RestaurantListViewAdapter(restaurants, getActivity());
        listView.setAdapter(adapter);
    }


}
