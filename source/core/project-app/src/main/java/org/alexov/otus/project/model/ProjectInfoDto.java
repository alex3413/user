package org.alexov.otus.project.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.context.annotation.Bean;

@Builder
@Schema(name = "Атрибуты нового проекта")
public class ProjectInfoDto {
    private String name;
    private String description;
    private String author;
    private String version;
    private ManifestInfo manifestInfo;
}
