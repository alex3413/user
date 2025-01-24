package org.alexov.otus.user.controller;

import org.alexov.otus.user.model.StatusReview;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserAudit(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(StatusReview.builder().userId(userId).status("ACCEPTED").date(LocalDateTime.now()).build());
    }
}
