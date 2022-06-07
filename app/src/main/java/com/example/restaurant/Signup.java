package com.example.restaurant;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "signup")
public class Signup {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String day;
    private String month;
    private String year;

    public Signup(String name, String email, String username, String password, String day, String month, String year) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
