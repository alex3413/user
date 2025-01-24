package org.alexov.otus.user.controller;

import lombok.RequiredArgsConstructor;
import org.alexov.otus.user.model.NotifyData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserNotification(@PathVariable("userId") Long userId) {

        return ResponseEntity.ok(NotifyData.builder().title("Account approved").userId(userId).date(now()).build());
    }

}
