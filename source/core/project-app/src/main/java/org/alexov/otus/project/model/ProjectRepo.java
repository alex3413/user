package org.alexov.otus.project.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<ProjectEntity ,Long > {
}
