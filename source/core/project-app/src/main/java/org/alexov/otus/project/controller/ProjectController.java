package org.alexov.otus.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.alexov.otus.project.model.ProjectInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Контроллер работы с проектом")
@RequestMapping("/project")
public class ProjectController {

    @Operation(description = "Создать проект")
    @PostMapping("/create")
    public ResponseEntity<?> createProject(@RequestBody ProjectInfoDto projectInfo) {
        // All activities by project it's has a work with project manifest
        // TODO Requier update users audit
        // TODO validate manifest in manifest-app
        // TODO Notification user by new project with response validating data
        return ResponseEntity.ok().build();
    }


}
