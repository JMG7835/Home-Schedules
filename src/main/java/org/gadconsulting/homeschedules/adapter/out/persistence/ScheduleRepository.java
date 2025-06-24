package org.gadconsulting.homeschedules.adapter.out.persistence;

import org.gadconsulting.homeschedules.domain.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    List<Schedule> findAllByOrderByNameAsc();

    Optional<Schedule> findByName(String name);
}
