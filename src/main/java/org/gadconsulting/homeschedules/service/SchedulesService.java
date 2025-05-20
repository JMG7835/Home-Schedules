package org.gadconsulting.homeschedules.service;

import lombok.extern.slf4j.Slf4j;
import org.gadconsulting.homeschedules.dto.ScheduleDto;
import org.gadconsulting.homeschedules.mapper.SchedulesMapper;
import org.gadconsulting.homeschedules.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SchedulesService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private SchedulesMapper schedulesMapper;

    public ScheduleDto createSchedules(final ScheduleDto schedulesRequestDto) {

        ScheduleDto newSchedule = schedulesMapper.toDto(scheduleRepository.save(schedulesMapper.toEntity(schedulesRequestDto)));
        log.debug("schedule created " + newSchedule.toString());
        return newSchedule;
    }

}

