package org.gadconsulting.homeschedules.controller;

import org.gadconsulting.homeschedules.dto.ScheduleDto;
import org.gadconsulting.homeschedules.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/schedule")
public class SchedulesController {

    @Autowired
    private SchedulesService schedulesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchedules(@RequestBody ScheduleDto schedulesRequest) {
        //schedulesService.createSchedules(schedulesRequest);


    }

    @ResponseStatus(HttpStatus.OK)
    public void updateSchedules(@RequestBody ScheduleDto schedulesRequest) {

    }
}
