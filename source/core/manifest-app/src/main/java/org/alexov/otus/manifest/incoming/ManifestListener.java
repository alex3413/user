package org.alexov.otus.manifest.incoming;

import lombok.RequiredArgsConstructor;
import org.alexov.otus.common.model.ManifestData;
import org.alexov.otus.common.model.event.ManifestEvent;
import org.alexov.otus.manifest.model.ManifestEntity;
import org.alexov.otus.manifest.model.ManifestRepo;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static org.alexov.otus.manifest.incoming.ManifestEventType.MANIFEST_CREATED;

@Component
@RequiredArgsConstructor
public class ManifestListener {
    private final RabbitTemplate rabbitTemplate;
    private final ManifestRepo manifestRepo;

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("manifest_ex"),
            value = @Queue("q.message.manifest.project"),
            key = "key_project_created"),
    queues = "q.message.manifest.project")
    public void projectListener(ManifestData manifestData) {
        ManifestEntity manifest = manifestRepo.save(getManifestEntity(manifestData));
        rabbitTemplate.convertAndSend(MANIFEST_CREATED.getExchange(), MANIFEST_CREATED.getRoutingKey(), manifestEventBuild(manifest));
    }

    private static ManifestEntity getManifestEntity(ManifestData manifestData) {
        return ManifestEntity.builder().build();
    }

    private ManifestEvent manifestEventBuild(ManifestEntity manifest) {
        return ManifestEvent.builder()
                .manifestId(1L)
                .manifestStatus("CREATED")
                .projectId(manifest.getProjectId())
                .build();
    }
}
