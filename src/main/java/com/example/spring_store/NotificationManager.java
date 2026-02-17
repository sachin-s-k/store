package com.example.spring_store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {

    private NotificationService notificationService;

    @Autowired
    public NotificationManager(NotificationService notificationService){
        this.notificationService=notificationService;

    }

    public void setNotification(String message){
        notificationService.send(message);
    }


}
