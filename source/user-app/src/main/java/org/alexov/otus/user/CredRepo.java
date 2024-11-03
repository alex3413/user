package org.alexov.otus.user;

import org.springframework.data.repository.CrudRepository;

public interface CredRepo extends CrudRepository<UserCred, String> {
}
