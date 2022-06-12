package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageListViewAdapter extends BaseAdapter {

    private List<Message> messagesList;
    private Context context;

    public MessageListViewAdapter(List<Message> messagesList, Context context) {
        this.messagesList = messagesList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return messagesList.size();
    }

    @Override
    public Object getItem(int i) {
        return messagesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return messagesList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.message_list_view,viewGroup,false);
        Message message = messagesList.get(i);

        TextView subjectContact = view.findViewById(R.id.admin_subject);
        TextView emailContact = view.findViewById(R.id.admin_email);
        TextView messageContact = view.findViewById(R.id.admin_message);

        subjectContact.setText(message.getSubject());
        emailContact.setText(message.getEmail());
        messageContact.setText(message.getMessage());

        return view;
    }
}
