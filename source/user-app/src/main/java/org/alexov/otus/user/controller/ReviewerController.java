package org.alexov.otus.user.controller;

import org.alexov.otus.user.model.StatusReview;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/review")
public class ReviewerController {

    @PutMapping("/{projectId}")
    public ResponseEntity<?> putReviewerToProject(@PathVariable Long projectId, @RequestBody StatusReview statusReview) {
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{projectId}")
    public ResponseEntity<?> setReviewerStatusToProject(@PathVariable Long projectId, @RequestBody StatusReview statusReview) {
        return ResponseEntity.ok(StatusReview
                .builder().date(LocalDateTime.now())
                .status(statusReview.getStatus()).projectId(projectId).build());
    }
}
