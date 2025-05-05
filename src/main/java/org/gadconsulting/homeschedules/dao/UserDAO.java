package org.gadconsulting.homeschedules.dao;
import org.gadconsulting.homeschedules.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserDAO extends JpaRepository<User, Long> {
    }
