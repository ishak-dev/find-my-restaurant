package com.example.restaurant;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Signup.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SignupDao signupDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class,"signup_data").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
