package org.gadconsulting.homeschedules.service;

import org.gadconsulting.homeschedules.dto.SchedulesDto;
import org.gadconsulting.homeschedules.model.Schedule;
import org.gadconsulting.homeschedules.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class SchedulesServiceTest {

    @Mock
    private ScheduleRepository scheduleRepositoryMock;
    @Captor
    private ArgumentCaptor<Schedule> scheduleCaptor;
    @InjectMocks
    private SchedulesService schedulesService;

    @Test
    public void testCreateSchedules() {
        final SchedulesDto schedulesDto = new SchedulesDto();
        schedulesService.createSchedules(schedulesDto);
        verify(scheduleRepositoryMock).save(scheduleCaptor.capture());

        Schedule schedule = scheduleCaptor.getValue();
        assertThat(schedule.getTitle()).isEqualTo(schedulesDto.getTitle());
        assertThat(schedule.getStatus()).isEqualTo(schedulesDto.getStatus());
        assertThat(schedule.getStartDate()).isEqualTo(schedulesDto.getStartDate());

    }


}
