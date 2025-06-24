package org.gadconsulting.homeschedules.adapter.in.web.controller;

import org.gadconsulting.homeschedules.adapter.in.dto.UserDto;
import org.gadconsulting.homeschedules.application.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{userName}")
    public ResponseEntity<List<UserDto>> getUsers(@RequestBody String userName) {
        return ResponseEntity.ok(usersService.getUsers(userName));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(usersService.getUsers());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUsers(@RequestBody UserDto user) {
        return ResponseEntity.ok(usersService.createUserOrUpdate(user));
    }

    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> updateSchedules(@RequestBody UserDto user) {
        return ResponseEntity.ok(usersService.createUserOrUpdate(user));
    }
}
