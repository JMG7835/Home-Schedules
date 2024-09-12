package org.gadconsulting.homeschedules.controller;

import org.gadconsulting.homeschedules.dto.SchedulesRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class SchedulesController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchedules(@RequestBody SchedulesRequestDto schedulesRequest){

    }

    @ResponseStatus(HttpStatus.OK)
    public void updateSchedules(@RequestBody SchedulesRequestDto schedulesRequest){

    }
}
