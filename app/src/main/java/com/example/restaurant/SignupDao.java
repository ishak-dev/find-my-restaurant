package com.example.restaurant;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SignupDao {
    @Insert
    void add(Signup signup);

    @Query("SELECT * FROM signup WHERE email=:email LIMIT 1")
    Signup getUserByEmail(String email);


    @Query("SELECT * FROM signup WHERE email=:email AND password=:password LIMIT 1")
    Signup getUserByPassword(String email,String password);

    @Query("UPDATE signup SET password=:password WHERE email=:email")
    Void updatePassword(String password,String email);


}
