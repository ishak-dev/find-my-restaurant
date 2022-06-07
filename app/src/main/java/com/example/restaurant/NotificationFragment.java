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
    public static final String EXTRAS_TITLE = "EXTRAS_TITLE";
    public static final String EXTRAS_MESSAGE = "EXTRAS_MESSAGE";
    public static final String EXTRAS_TIME = "EXTRAS_TIME";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.notification_fragment,viewGroup, false);
        listView = view.findViewById(R.id.list_view_notification);

        NotificationListViewAdapter notificationListViewAdapter = new NotificationListViewAdapter(getNotifications(), getActivity());
        listView.setAdapter(notificationListViewAdapter);
        listView.setOnItemClickListener(onItemClickListener);
        return view;
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Notification notification = (Notification) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(getActivity(),NotificationDetails.class);
            intent.putExtra(EXTRAS_TITLE,notification.getNotificationTitle());
            intent.putExtra(EXTRAS_MESSAGE,notification.getNotificationMessage());
            intent.putExtra(EXTRAS_TIME,notification.getNotificationTime());
            startActivity(intent);
        }
    };

    private List<Notification> getNotifications(){
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification("New restaurant in Sarajevo","Findout which restaurant is opened recently","14:40"));
        notificationList.add(new Notification("New restaurant in Zenica","Findout which restaurant is opened recently","14:40"));
        notificationList.add(new Notification("New restaurant in Mostar","Findout which restaurant is opened recently","14:40"));
        notificationList.add(new Notification("New restaurant in Tuzla","Findout which restaurant is opened recently","14:40"));
        return  notificationList;
    }
}
