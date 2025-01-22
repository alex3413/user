package org.alexov.otus.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.alexov.otus.project.facade.ProjectProcessorFacade;
import org.alexov.otus.project.model.ProjectEntity;
import org.alexov.otus.project.model.ProjectInfoDto;
import org.alexov.otus.project.model.ProjectRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Контроллер работы с проектом")
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectProcessorFacade processor;
    private final ProjectRepo projectRepo;

    @Operation(description = "Создать проект")
    @PostMapping("/create")
    public ResponseEntity<Long> createProject(@RequestBody ProjectInfoDto projectInfo) {
        return ResponseEntity.ok(processor.processProjectCreate(projectInfo));
    }

    @Operation(description = "Получить статус проекта")
    @GetMapping("/status")
    public ResponseEntity<?> getProjectStatus(@RequestParam Long projectId) {
        return projectRepo.findById(projectId)
                .map(p -> ResponseEntity.ok(p.getStatus()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ProjectInfoDto> getProjectsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectInfoDto> getProjectInfo(@PathVariable Long projectId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> addUserToProject(@PathVariable Long projectId, @RequestBody Long userId) {
        return ResponseEntity.ok().build();
    }

}
