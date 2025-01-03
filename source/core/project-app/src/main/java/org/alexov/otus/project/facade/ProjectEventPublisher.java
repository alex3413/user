package org.alexov.otus.project.facade;

import lombok.RequiredArgsConstructor;
import org.alexov.otus.common.model.event.ProjectEvent;
import org.alexov.otus.project.model.ManifestData;
import org.alexov.otus.project.model.ProjectEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishEvent(ProjectEventType eventType, ProjectEntity project){

        rabbitTemplate.convertAndSend(eventType.getExchange(),eventType.getRoutingKey(), projectEventBuild(project));
    }

    private ProjectEvent projectEventBuild(ProjectEntity project) {
        return ProjectEvent.builder()
                .id(project.getId())
                .version(project.getVersion())
                .status(project.getStatus())
                .updatedAt(project.getUpdateAt())
                .build();
    }

    public void publishEvent(ProjectEventType eventType, ManifestData manifestData){
        rabbitTemplate.convertAndSend(eventType.getExchange(),eventType.getRoutingKey(), manifestData);
    }

}
