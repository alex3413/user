package org.alexov.otus.notification.controller;

import lombok.RequiredArgsConstructor;
import org.alexov.otus.notification.model.Notification;
import org.alexov.otus.notification.model.NotificationRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationRepo notificationRepo;

    @GetMapping("/{userId}/get")
    public ResponseEntity<?> getUserNotification(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(notificationRepo.findByUserId(userId));
    }
    @PostMapping(value = "/api/notification/{userId}")
    public ResponseEntity<Notification> createNotification(@PathVariable("userId") Long userId, @RequestBody Notification notification) {
        notification.setUserId(userId);
        Notification note = notificationRepo.save(notification);
        return ResponseEntity.ok(note);
    }


}
