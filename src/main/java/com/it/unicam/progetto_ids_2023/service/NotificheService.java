package com.it.unicam.progetto_ids_2023.service;

import org.springframework.beans.factory.annotation.Autowired;

public class NotificheService {
/*
    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(String recipient, NotificationType type, Content associatedContent) {
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setType(type);
        notification.setAssociatedContent(associatedContent);
        notification.setRead(false);
        notificationRepository.save(notification);
    }

    public List<Notification> getNotifications(String recipient) {
        return notificationRepository.findByRecipientOrderByCreatedAtDesc(recipient);
    }

    public void markAsRead(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        optionalNotification.ifPresent(notification -> {
            notification.setRead(true);
            notificationRepository.save(notification);
        });
    }*/
}
