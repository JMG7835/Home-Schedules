package org.gadconsulting.homeschedules.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchedulesDto {
    private String title;
    private String description;
    private String location;
    private String startDate;
    private String endDate;
    private String status;
    private UserDto principalUser;
    private List<UserDto> additionalUsers;
}