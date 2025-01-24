package org.alexov.otus.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.alexov.otus.user.model.NotifyData;
import org.alexov.otus.user.model.ProjectInfoDto;
import org.alexov.otus.user.model.StatusReview;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Контроллер работы с проектом")
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    @Operation(description = "Создать проект")
    @PostMapping("/create")
    public ResponseEntity<Long> createProject(@RequestBody ProjectInfoDto projectInfo) {
        return ResponseEntity.ok().build();
    }

    @Operation(description = "Получить статус проекта")
    @GetMapping("/status")
    public ResponseEntity<?> getProjectStatus(@RequestParam Long projectId) {
        return ResponseEntity.ok(StatusReview.builder().status("CREATE").projectId(projectId).userId(2L).build());
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<ProjectInfoDto> getProjectsByUser(@PathVariable Long userId) {
//        return ResponseEntity.ok().build();
//    }
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectInfoDto> getProjectInfo(@PathVariable Long projectId) {
        return ResponseEntity.ok(ProjectInfoDto.builder()
                .description("Архитектура как код")
                .author("Ovchinnikovav")
                .version("v1.0.0")
                .name("Учебный проект курса ОТУС \"Архитектура как код\"").build());
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> addUserToProject(@PathVariable Long projectId, @RequestBody Long userId) {
        return ResponseEntity.ok().build();
    }

}
