package org.gadconsulting.homeschedules.controller;

import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public void getUsers(@RequestBody String userName) {
       // usersService.getUsers(userName);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void getUsers() {
       // usersService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUsers(@RequestBody UserDto user) {
        //usersService.createUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    public void updateSchedules(@RequestBody UserDto user) {
       // usersService.updateUser(user);
    }
}
