package org.alexov.otus.notification.controller;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("project_ex"),
            value = @Queue("q.event.notification.project"),
            key = "created"),
            queues = "q.event.notification.project")
    public void projectListener() {

    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("manifest_ex"),
            value = @Queue("q.event.notification.manifest"),
            key = "created_key"),
            queues = "q.event.notification.manifest")
    public void manifestListener() {

    }
}
