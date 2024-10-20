package org.alexov.otus.auth;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<MyUserDetails, Long> {
    Optional<MyUserDetails> findByUsername(String username);
    void deleteByUsername(String username);
}
