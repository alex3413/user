package org.alexov.otus.user.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<OtusUser, Long> {
    void deleteById(Long id);
    Optional<OtusUser> findByUsername(String username);
}
