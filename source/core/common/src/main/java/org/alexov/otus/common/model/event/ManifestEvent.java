package org.alexov.otus.common.model.event;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ManifestEvent {
    private Long manifestId;
    private String projectId;
    private String projectVersion;
    private String manifestVersion;
    private String manifestStatus;
}
