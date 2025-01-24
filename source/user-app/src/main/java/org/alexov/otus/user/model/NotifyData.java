package org.alexov.otus.user.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotifyData {
    private String title;
    private Long userId;
    private LocalDateTime date;
}
