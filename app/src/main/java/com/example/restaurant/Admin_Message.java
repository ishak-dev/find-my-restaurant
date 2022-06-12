package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class Admin_Message extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_message);

        listView = findViewById(R.id.list_view_message);
        setUpListAdapter();

    }


    public void setUpListAdapter(){
        List<Message> messageList = AppDatabase.getInstance(this).messageDao().getAllMessage();
        MessageListViewAdapter adapter = new MessageListViewAdapter(messageList,this);
        listView.setAdapter(adapter);
    }
}