package org.gadconsulting.homeschedules.service;

import org.gadconsulting.homeschedules.dto.SchedulesDto;
import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.model.Schedule;
import org.gadconsulting.homeschedules.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SchedulesServiceTest {

    @Mock
    private ScheduleRepository scheduleRepositoryMock;

    @Captor
    private ArgumentCaptor<Schedule> scheduleCaptor;

    @InjectMocks
    private SchedulesService schedulesService = new SchedulesService();

    @Test
    public void testCreateSchedules() {

        final UserDto userDto = UserDto.builder()
                .phone("0123456789").build();
        final SchedulesDto schedulesDto = SchedulesDto.builder().principalUser(userDto).build();

        when(scheduleRepositoryMock.save(any())).thenReturn(new Schedule());
        schedulesService.createSchedules(schedulesDto);
        verify(scheduleRepositoryMock, times(1)).save(scheduleCaptor.capture());

        Schedule schedule = scheduleCaptor.getValue();
        assertThat(schedule.getTitle()).isEqualTo(schedulesDto.getTitle());
        assertThat(schedule.getStatus()).isEqualTo(schedulesDto.getStatus());
        assertThat(schedule.getStartDate()).isEqualTo(schedulesDto.getStartDate());

    }


}
