package org.alexov.otus.project.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.alexov.otus.project.model.ProjectEntity;
import org.alexov.otus.project.model.ProjectInfoDto;
import org.alexov.otus.project.model.ProjectRepo;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectProcessorFacade {
    private final ProjectEventPublisher eventPublisher;
    private final RestClientSender restClient;
    private final ProjectRepo projectRepo;
    private final ObjectMapper objectMapper;

    // All activities by project it's has a work with project manifest
    // TODO Requier update users audit
    // TODO validate manifest in manifest-app
    // TODO Notification user by new project with response validating data
    public ProjectEventType processProjectCreate(ProjectInfoDto projectInfoDto) {
        var profile = restClient.getUserProfile();
        try {
            ProjectEntity project = projectRepo.save(buildProject(projectInfoDto, profile));
            eventPublisher.publishEvent(ProjectEventType.PROJECT_CREATED, project);
            eventPublisher.publishEvent(ProjectEventType.MANIFEST_CREATE, projectInfoDto.getManifestInfo());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ProjectEventType.PROJECT_CREATED;
    }

    private ProjectEntity buildProject(ProjectInfoDto projectInfoDto, Long userId) throws JsonProcessingException {
        return ProjectEntity.builder()
                .author(projectInfoDto.getAuthor())
                .version(projectInfoDto.getVersion())
                .userId(userId)
                .description(projectInfoDto.getDescription())
                .projectData(objectMapper.writeValueAsString(projectInfoDto))
                .create_at(LocalDateTime.now())
                .build();
    }
}
