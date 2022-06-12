package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotificationListViewAdapter extends BaseAdapter {

    private List<Notification> notificationList;
    private Context context;

    public NotificationListViewAdapter(List<Notification> notificationList, Context context) {
        this.notificationList = notificationList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public Object getItem(int i) {
        return notificationList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return notificationList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.notificaiton_list_view,viewGroup,false);
        Notification notification = notificationList.get(i);

        TextView titleTextView = view.findViewById(R.id.notificatonTitle);
        TextView messageTextView = view.findViewById(R.id.notificationMessage);
        TextView timeTextView = view.findViewById(R.id.notificationTime);

        titleTextView.setText(notification.getNotificationTitle());
        messageTextView.setText(notification.getNotificationMessage());
        timeTextView.setText(notification.getNotificationTime());


        return view;
    }
}
