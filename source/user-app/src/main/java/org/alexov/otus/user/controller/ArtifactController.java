package org.alexov.otus.user.controller;

import org.alexov.otus.user.model.ProjectInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artifact")
public class ArtifactController {

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getArtifactByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(ProjectInfoDto.builder()
                .fileId("IDL_proj_1.yaml")
                .description("описание API в формате IDL-openapi")
                .name("API проекта \"Архитектура как код\" ")
                .author("Ovchinnikov Alexandr")
                .version("1.0.0").build());
    }
}
