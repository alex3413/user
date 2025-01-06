package org.alexov.otus.project.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
public class ManifestData {
    private String version;
    private String projectId;
    private String fileId;
    private Map<String, ArchComponent> components = new HashMap<>();

    @Builder
    @Data
    public static class ArchComponent {
        private String type;
        private String title;
        private String description;
        private String dockerImage;
        private List<String> technologies;
        private List<Link> links;
        private List<ArchOperation> operations = new ArrayList<>();
        private List<String> eventPublisher = new ArrayList<>();
        private List<String> eventSubscriber = new ArrayList<>();


    }
    @Builder
    @Data
    private static class Link {
        private String dependencyId;
        private List<ArchOperation> operations = new ArrayList<>();
    }

    @Builder
    @Data
    private static class ArchOperation {
        private String id;
        private String type;
        private String direction;
        private String method;
        private String uri;
        private Map<String, String> model = new HashMap<>();
    }
}
