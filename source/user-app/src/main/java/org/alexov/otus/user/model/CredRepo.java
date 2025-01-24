package org.alexov.otus.user.model;

import org.springframework.data.repository.CrudRepository;

public interface CredRepo extends CrudRepository<UserCred, String> {
}
