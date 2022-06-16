package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    EditText email,username,password,birthDay, birthMonth, birthYear;
    TextView name;
    private String getEmail;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.profile_fragment, viewGroup, false);

        name =  view.findViewById(R.id.user_name);
        username = view.findViewById(R.id.user_username);
        email = view.findViewById(R.id.user_email);
        password = view.findViewById(R.id.user_password);
        birthDay = view.findViewById(R.id.user_birth_day);
        birthMonth = view.findViewById(R.id.user_birth_month);
        birthYear = view.findViewById(R.id.user_birth_year);

        Bundle extras = getActivity().getIntent().getExtras();
        getEmail = extras.getString(Login.EXTRA_USER_EMAIL);
        Signup user = AppDatabase.getInstance(getActivity()).signupDao().getUserByEmail(getEmail);
        username.setText(user.getUsername());
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        birthDay.setText(user.getDay());
        birthMonth.setText(user.getMonth());
        birthYear.setText(user.getYear());
        name.setText(user.getName());

        Button button = view.findViewById(R.id.changePass_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = password.getText().toString();
                AppDatabase.getInstance(getActivity()).signupDao().updatePassword(newPassword,getEmail);
                Toast.makeText(getActivity(), "Password changed", Toast.LENGTH_SHORT).show();
            }
        });




        return view;
    }




}
