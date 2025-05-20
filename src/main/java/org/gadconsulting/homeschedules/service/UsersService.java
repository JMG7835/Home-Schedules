package org.gadconsulting.homeschedules.service;

import lombok.extern.slf4j.Slf4j;
import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.mapper.UserMapper;
import org.gadconsulting.homeschedules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    public List<UserDto> getUsers(final String user) {
        log.info("user call with '{}'",user);
        return userMapper.toDtos(userRepository.findByNameContainsOrderByNameAsc(user));
    }

    public List<UserDto> getUsers() {
        log.info("alluser");
        return userMapper.toDtos(userRepository.findAllByOrderByNameAsc());
    }

    public UserDto getUser(final String user) {
        log.info("find user '{}'",user);
        return userMapper.toDto(userRepository.findByName(user));
    }

    public UserDto createUserOrUpdate(final UserDto userDto) {

        log.info("create user '{}'",userDto.getName());
        UserDto newUserDto = userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
        log.info("user Created");
        return newUserDto;
    }
}