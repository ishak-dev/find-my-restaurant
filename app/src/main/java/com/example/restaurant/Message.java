package com.example.restaurant;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "messages")
public class Message {
    @PrimaryKey(autoGenerate = true)
            long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String email;
    String subject;
    String message;

    public Message(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
