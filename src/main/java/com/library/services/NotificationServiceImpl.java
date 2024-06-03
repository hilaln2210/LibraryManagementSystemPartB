package com.library.services;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("Notification: " + message);
    }
}
