package org.alexov.otus.notification.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.alexov.otus.common.model.event.ManifestEvent;
import org.alexov.otus.common.model.event.ProjectEvent;
import org.alexov.otus.notification.model.Notification;
import org.alexov.otus.notification.model.NotificationRepo;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final NotificationRepo notificationRepo;
    private final ObjectMapper objectMapper;

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("project_ex"),
            value = @Queue("q.event.notification.project"),
            key = "created"),
            queues = "q.event.notification.project")
    public void projectListener(ProjectEvent projectEvent) throws JsonProcessingException {
        notificationRepo.save(notificationBuild(objectMapper.writeValueAsString(projectEvent), Long.getLong(projectEvent.getUserId())));
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("manifest_ex"),
            value = @Queue("q.event.notification.manifest"),
            key = "created_key"),
            queues = "q.event.notification.manifest")
    public void manifestListener(ManifestEvent projectEvent) throws JsonProcessingException {
        notificationRepo.save(notificationBuild(objectMapper.writeValueAsString(projectEvent), projectEvent.getUserId()));
    }

    private Notification notificationBuild(String s, Long userId) {
        return Notification.builder()
                .note(s)
                .status("SENT")
                .userId(userId)
                .noteDate(LocalDateTime.now())
                .sendDate(LocalDateTime.now())
                .build();
    }
}
