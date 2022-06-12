package com.example.restaurant;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Signup.class,RestaurantModel.class,Notification.class,Message.class},version = 5,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SignupDao signupDao();
    public abstract RestaurantDao restaurantDao();
    public abstract NotificationDao notificationDao();
    public abstract MessageDao messageDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class,"signup_data").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
