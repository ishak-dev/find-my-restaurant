package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Admin_Notificaiton_Activity extends AppCompatActivity {

    EditText title,description;
    public static final String CHANNEL_ID="My channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notificaiton);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel(CHANNEL_ID, "My custom channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }


        title = findViewById(R.id.setTitle_notification);
        description = findViewById(R.id.setDescription_notification);
    }

    public void onSend(View view){

        Date currentTime = Calendar.getInstance().getTime();
        Notification notification = new Notification(
                title.getText().toString(),
                description.getText().toString(),
                currentTime.toString()
        );
        AppDatabase.getInstance(this).notificationDao().addNotif(notification);

        Intent intent = new Intent(this,AdminDashboard.class);
        startActivity(intent);
        Toast.makeText(this, "Notification sent", Toast.LENGTH_SHORT).show();

        new AlertDialog.Builder(Admin_Notificaiton_Activity.this).setTitle(R.string.app_name).setMessage(description.getText().toString()).show();

        Intent intent2  = new Intent(this, AdminDashboard.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 0, intent2, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(Admin_Notificaiton_Activity.this,CHANNEL_ID);
        builder.setContentTitle(title.getText().toString())
                .setContentText(description.getText().toString())
                .setSmallIcon(R.drawable.burger);


        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Admin_Notificaiton_Activity.this);
        managerCompat.notify(1,builder.build());





    }
}