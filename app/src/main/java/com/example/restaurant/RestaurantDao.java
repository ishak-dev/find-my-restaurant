package com.example.restaurant;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RestaurantDao {
    @Insert
    void add(RestaurantModel restaurant);

    @Query("SELECT * FROM restaurants")
    List<RestaurantModel> getAll();

    @Query("SELECT * FROM restaurants WHERE id=:id LIMIT 1")
    RestaurantModel getById(long id);

    @Query("DELETE FROM restaurants WHERE id=:id")
    void deleteById(long id);

    @Query("UPDATE restaurants SET imageResId=:imageResId, title=:title, description =:desc, longDescription=:longDesc,review=:rev,expensive=:exp,location=:loc,url=:url WHERE id=:id")
    void updateRest(long id, String imageResId,String title,String desc, String longDesc, String rev,String exp, String loc, String url);

}
