package org.gadconsulting.homeschedules.domain.ports.out.repository;

import org.gadconsulting.homeschedules.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findByNameContains(String name);

    List<User> findAll();

    Optional<User> findByName(String name);

    User save(User user);
}
