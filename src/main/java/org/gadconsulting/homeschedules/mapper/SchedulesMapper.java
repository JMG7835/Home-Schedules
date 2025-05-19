package org.gadconsulting.homeschedules.mapper;

import org.gadconsulting.homeschedules.dto.ScheduleDto;
import org.gadconsulting.homeschedules.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface SchedulesMapper {

    SchedulesMapper INSTANCE = Mappers.getMapper(SchedulesMapper.class);

    ScheduleDto toDto(Schedule schedule);

    Schedule toEntity(ScheduleDto scheduleDto);

    List<ScheduleDto> toDtos(List<Schedule> users);

    List<Schedule> toEntitys(List<ScheduleDto> users);

}
