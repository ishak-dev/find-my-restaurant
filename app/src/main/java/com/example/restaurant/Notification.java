package com.example.restaurant;

public class Notification {
    private String notificationTitle;
    private String notificationMessage;
    private String notificationTime;

    public Notification(String notificationTitle, String notificationMessage, String notificationTime) {
        this.notificationTitle = notificationTitle;
        this.notificationMessage = notificationMessage;
        this.notificationTime = notificationTime;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }
}
