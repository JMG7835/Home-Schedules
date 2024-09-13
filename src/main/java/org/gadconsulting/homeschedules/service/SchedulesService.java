package org.gadconsulting.homeschedules.service;

import lombok.extern.slf4j.Slf4j;
import org.gadconsulting.homeschedules.dto.SchedulesDto;
import org.gadconsulting.homeschedules.model.Schedule;
import org.gadconsulting.homeschedules.model.User;
import org.gadconsulting.homeschedules.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class SchedulesService {
    @Autowired
    private ScheduleRepository scheduleRepository;



    public void createSchedules(final SchedulesDto schedulesRequestDto) {

        final Set<User> additionalUsers = new HashSet<>();
        if(schedulesRequestDto.getAdditionalUsers() != null) {
            schedulesRequestDto.getAdditionalUsers().stream().forEach(additionalUser -> additionalUsers.add(User.builder()
                    .phone(additionalUser.getPhone())
                    .name(additionalUser.getName())
                    .address(additionalUser.getAddress())
                    .email(additionalUser.getEmail())
                    .city(additionalUser.getCity())
                    .zip(additionalUser.getZip())
                    .build()));
        }
        final Schedule schedule = Schedule.builder()
                .title(schedulesRequestDto.getTitle())
                .description(schedulesRequestDto.getDescription())
                .location(schedulesRequestDto.getLocation())
                .startDate(schedulesRequestDto.getStartDate())
                .endDate(schedulesRequestDto.getEndDate())
                .status(schedulesRequestDto.getStatus())
                .principalUser(User.builder()
                        .phone(schedulesRequestDto.getPrincipalUser().getPhone())
                        .name(schedulesRequestDto.getPrincipalUser().getName())
                        .address(schedulesRequestDto.getPrincipalUser().getAddress())
                        .email(schedulesRequestDto.getPrincipalUser().getEmail())
                        .city(schedulesRequestDto.getPrincipalUser().getCity())
                        .zip(schedulesRequestDto.getPrincipalUser().getZip())
                        .build())
                .additionalUsers(additionalUsers).build();
        scheduleRepository.save(schedule);
        log.debug("Created Schedule: {}", schedule.getId());
    }


}

