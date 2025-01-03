package org.alexov.otus.audit.incoming;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AuditListener {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("project_ex"),
            value = @Queue("q.event.audit.project"),
            key = "created"),
            queues = "q.event.audit.project")
    public void projectListener() {

    }
}

