package com.example.restaurant;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotificationDao {

    @Insert
    void addNotif(Notification notification);

    @Query("SELECT * FROM notification ")
    List<Notification> getAllNotf();

    @Query("SELECT * FROM notification WHERE id=:id LIMIT 1")
    Notification getNotifById(long id);

}
