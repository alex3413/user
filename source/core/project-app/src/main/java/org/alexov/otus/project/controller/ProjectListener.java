package org.alexov.otus.project.controller;

import lombok.RequiredArgsConstructor;
import org.alexov.otus.common.model.event.ManifestEvent;
import org.alexov.otus.project.model.ProjectEntity;
import org.alexov.otus.project.model.ProjectRepo;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProjectListener {
    private final ProjectRepo projectRepo;

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("manifest_ex"),
            value = @Queue("q.event.project.manifest"),
            key = "created_key"),
            queues = "q.event.project.manifest")
    @Transactional
    public void manifestListener(ManifestEvent manifestEvent) {
        if ("CREATED".equals(manifestEvent.getManifestStatus())) {
            Optional<ProjectEntity> project = projectRepo.findById(Long.valueOf(manifestEvent.getProjectId()));
            if (project.isPresent()) {
                ProjectEntity projectEntity = project.get();
                projectEntity.setStatus("MANIFEST_CREATED");
            }
        }
    }
}
