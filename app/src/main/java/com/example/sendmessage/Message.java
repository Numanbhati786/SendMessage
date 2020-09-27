package com.example.sendmessage;

public class Message {
    String to;
    NotificationData notificationData;

    public Message(String to, NotificationData notificationData) {
        this.to = to;
        this.notificationData = notificationData;
    }
    /*public NotificationSender() {
    }*/
}
