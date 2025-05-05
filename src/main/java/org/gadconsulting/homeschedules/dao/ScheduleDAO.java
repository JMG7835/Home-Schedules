package org.gadconsulting.homeschedules.dao;
import org.gadconsulting.homeschedules.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleDAO extends JpaRepository<Schedule, Long> {

}
