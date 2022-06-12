package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {



    private ListView listView;
    public static final String EXTRAS_ID = "NotificationFragment/EXTRAS_ID";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.notification_fragment,viewGroup, false);
        listView = view.findViewById(R.id.list_view_notification);

        getNotifications();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                long id = adapterView.getItemIdAtPosition(i);
                Intent intent = new Intent(getActivity(),NotificationDetails.class);
                intent.putExtra(EXTRAS_ID,id);
                startActivity(intent);
            }
        });
        return view;
    }


    public void getNotifications(){
        List<Notification> notificationList = AppDatabase.getInstance(getActivity()).notificationDao().getAllNotf();
        NotificationListViewAdapter adapter = new NotificationListViewAdapter(notificationList, getActivity());
        listView.setAdapter(adapter);


    }
}
