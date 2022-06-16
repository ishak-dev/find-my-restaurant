package com.example.restaurant;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReviewDao {
    @Insert
    void add(Review review);

    @Query("SELECT * FROM reviews WHERE restaurant_id=:id")
    List<Review> listAllRew(long id);
}
