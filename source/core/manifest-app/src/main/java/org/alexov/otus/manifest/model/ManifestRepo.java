package org.alexov.otus.manifest.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManifestRepo extends JpaRepository<ManifestEntity, Long> {
}
