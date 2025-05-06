package org.gadconsulting.homeschedules.repository;
import org.gadconsulting.homeschedules.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    }
