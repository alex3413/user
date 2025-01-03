package org.alexov.otus.project.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<ProjectEntity ,Long > {
}
