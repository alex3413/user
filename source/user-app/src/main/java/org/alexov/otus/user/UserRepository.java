package org.alexov.otus.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<OtusUser, Long> {
    void deleteById(Long id);
}
