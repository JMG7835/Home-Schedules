package org.gadconsulting.homeschedules.repository;
import org.gadconsulting.homeschedules.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContainsOrderByNameAsc(final String name);

    List<User> findAllByOrderByNameAsc();

    User findByName(final String user);
}
