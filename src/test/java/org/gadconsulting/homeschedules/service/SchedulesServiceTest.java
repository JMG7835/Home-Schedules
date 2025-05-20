package org.gadconsulting.homeschedules.service;

import org.gadconsulting.homeschedules.dto.ScheduleDto;
import org.gadconsulting.homeschedules.mapper.SchedulesMapper;
import org.gadconsulting.homeschedules.model.Schedule;
import org.gadconsulting.homeschedules.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SchedulesServiceTest {

    @Mock
    private ScheduleRepository scheduleRepositoryMock;

    @Mock
    private SchedulesMapper schedulesMapper;

    @Captor
    private ArgumentCaptor<Schedule> scheduleCaptor;

    @InjectMocks
    private SchedulesService schedulesService = new SchedulesService();

    @Test
    public void testCreateSchedules() {



        when(scheduleRepositoryMock.save(any())).thenReturn(new Schedule());
        when(schedulesMapper.toDto(any())).thenReturn(new ScheduleDto());
        when(schedulesMapper.toEntity(any())).thenReturn(new Schedule());
        schedulesService.createSchedules(new ScheduleDto());
        verify(scheduleRepositoryMock, times(1)).save(scheduleCaptor.capture());
    }


}
