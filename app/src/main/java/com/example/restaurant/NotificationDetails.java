package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationDetails extends AppCompatActivity {

    private TextView title;
    private TextView message;
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_details);

        title = findViewById(R.id.notificationTitle_details);
        message = findViewById(R.id.notificationMessage_details);
        time = findViewById(R.id.notificationTime_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            setTitle(extras.getString(NotificationFragment.EXTRAS_TITLE));
            title.setText(extras.getString(NotificationFragment.EXTRAS_TITLE));
            message.setText(extras.getString(NotificationFragment.EXTRAS_MESSAGE));
            time.setText(extras.getString(NotificationFragment.EXTRAS_TIME));
        }
    }
}