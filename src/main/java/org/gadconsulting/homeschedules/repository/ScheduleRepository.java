package org.gadconsulting.homeschedules.repository;
import org.gadconsulting.homeschedules.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule,String> {

}
