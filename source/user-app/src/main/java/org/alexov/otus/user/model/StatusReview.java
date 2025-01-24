package org.alexov.otus.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class StatusReview {
    private Long userId;
    private String status;
    private Long projectId;
    private LocalDateTime date;
}
