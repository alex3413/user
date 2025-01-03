package org.alexov.otus.project.facade;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProjectEventType {
    PROJECT_CREATED("project_ex", "created"),
    PROJECT_UPDATED("project_ex", "updated"),
    PROJECT_DELETED("project_ex", "deleted"),
    MANIFEST_CREATE("manifest_ex", "key_project_created");

    private final String exchange;
    private final String routingKey;
}
