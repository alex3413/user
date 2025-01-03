package org.alexov.otus.common.model.event;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ProjectEvent {
    private Long id;
    private String version;
    private String userId;
    private LocalDateTime updatedAt;
    private String status;
}
