package org.alexov.otus.manifest.incoming;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ManifestEventType {
    MANIFEST_CREATED("manifest_ex", "created_key"),;
    private final String exchange;
    private final String routingKey;
}
