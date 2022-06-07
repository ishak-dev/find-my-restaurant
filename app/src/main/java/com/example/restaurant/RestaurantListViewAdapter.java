package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestaurantListViewAdapter extends BaseAdapter {
    private List<RestaurantModel> restaurantModelList;
    private Context context;

    public RestaurantListViewAdapter(List<RestaurantModel> restaurantModelList, Context context) {
        this.restaurantModelList = restaurantModelList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return restaurantModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return restaurantModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return restaurantModelList.indexOf(restaurantModelList.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.restaurant_list_view,viewGroup,false);
        RestaurantModel restaurantModel = restaurantModelList.get(i);

        ImageView imageView = view.findViewById(R.id.restaurant_image);
        TextView titleTextView = view.findViewById(R.id.restaurant_title);
        TextView descriptionTextView = view.findViewById(R.id.restaurant_description);
        TextView expensiveTextView = view.findViewById(R.id.restaurant_expensive);
        TextView reviewTextView = view.findViewById(R.id.restaurant_review);

        imageView.setImageResource(restaurantModel.getImageResId());
        titleTextView.setText(restaurantModel.getTitle());
        descriptionTextView.setText(restaurantModel.getDescription());
        expensiveTextView.setText(restaurantModel.getExpensive());
        reviewTextView.setText(restaurantModel.getReview());


        return view;
    }
}
