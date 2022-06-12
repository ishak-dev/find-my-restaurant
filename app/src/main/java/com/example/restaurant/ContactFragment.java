package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class ContactFragment extends Fragment {

    EditText subjectContact, messageContact;
    Button sendIt;
    String emailUser;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.contact_fragment, viewGroup, false);

        subjectContact = view.findViewById(R.id.contact_subject);
        messageContact = view.findViewById(R.id.contact_message);
        sendIt = view.findViewById(R.id.send_btn);

        Bundle extras = getActivity().getIntent().getExtras();
        emailUser = extras.getString(Login.EXTRA_USER_EMAIL);

        sendIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message(
                        emailUser,
                        subjectContact.getText().toString(),
                        messageContact.getText().toString()
                );
                AppDatabase.getInstance(getActivity()).messageDao().add(message);
                subjectContact.setText("");
                messageContact.setText("");
                Toast.makeText(getActivity(), "You sent a message", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
