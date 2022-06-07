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
    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";
    public static final String EXTRA_LONG_DESCRIPTION = "EXTRA_LONG_DESCRIPTION";
    public static final String EXTRA_REVIEW= "EXTRA_REVIEW";
    public static final String EXTRA_EXPENSIVE = "EXTRA_EXPENSIVE";
    public static final String EXTRA_URL = "EXTRA_URL";
    public static final String EXTRA_LOCATION = "EXTRA_LOCATION";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.home_fragment, viewGroup, false);
        listView =(ListView) view.findViewById(R.id.list_view);
        RestaurantListViewAdapter restaurantListViewAdapter = new RestaurantListViewAdapter(getRestaurants(),getActivity());
        listView.setAdapter(restaurantListViewAdapter);
        listView.setOnItemClickListener(onItemClickListener);

        TextView restaurantNumber = (TextView) view.findViewById(R.id.restaurantNumber);
        restaurantNumber.setText(restaurantListViewAdapter.getCount()+"");
        return view;
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            RestaurantModel restaurantModel = (RestaurantModel) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(getActivity(), RestaurantDetails.class);
            intent.putExtra(EXTRA_IMAGE,restaurantModel.getImageResId());
            intent.putExtra(EXTRA_TITLE,restaurantModel.getTitle());
            intent.putExtra(EXTRA_DESCRIPTION,restaurantModel.getDescription());
            intent.putExtra(EXTRA_LONG_DESCRIPTION,restaurantModel.getLongDescription());
            intent.putExtra(EXTRA_REVIEW,restaurantModel.getReview());
            intent.putExtra(EXTRA_EXPENSIVE,restaurantModel.getExpensive());
            intent.putExtra(EXTRA_URL,restaurantModel.getUrl());
            intent.putExtra(EXTRA_LOCATION,restaurantModel.getLocation());
            startActivity(intent);
        }
    };

    private List<RestaurantModel> getRestaurants(){
        List<RestaurantModel> restaurantModelList = new ArrayList<>();
        restaurantModelList.add(new RestaurantModel(R.drawable.brajlovic,"Restaurant Brajlovic","jd asjdl ajsdl jalsdj kalsjd l asd asd asd asd asd asd asd asd asd asd asd asd ","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum","4,5","$$$","Brajlovic","restoranbrajlovic.com"));
        restaurantModelList.add(new RestaurantModel(R.drawable.hodzic,"Restaurant Hodzic","jd asjdl ajsdl jalsdj kalsjd l","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum","4,3","$$","Hodzic ","hodzic.ba"));
        restaurantModelList.add(new RestaurantModel(R.drawable.mujanic,"Restaurant mujanic","jd asjdl ajsdl jalsdj kalsjd l","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum","4,6","$$","Mujanic restoran","mujanic.ba"));
        return restaurantModelList;
    }


}
