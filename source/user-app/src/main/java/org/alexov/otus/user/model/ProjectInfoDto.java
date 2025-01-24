package org.alexov.otus.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Schema(name = "Атрибуты нового проекта")
@Data
public class ProjectInfoDto {
    private String name;
    private String description;
    private String author;
    private String version;
    private String fileId;
}
