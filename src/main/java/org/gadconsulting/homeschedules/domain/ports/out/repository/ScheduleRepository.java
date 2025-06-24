package org.gadconsulting.homeschedules.domain.ports.out.repository;

import org.gadconsulting.homeschedules.domain.model.Schedule;

import java.util.List;
import java.util.Optional;


public interface ScheduleRepository {
    List<Schedule> findByNameContains(String name);

    List<Schedule> findAll();

    Optional<Schedule> findByName(String name);

    Schedule save(Schedule schedule);

}
