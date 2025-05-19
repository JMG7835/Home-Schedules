package org.gadconsulting.homeschedules.service;

import lombok.extern.slf4j.Slf4j;
import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.mapper.UserMapper;
import org.gadconsulting.homeschedules.model.User;
import org.gadconsulting.homeschedules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsersService {/*
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;




    public List<UserDto> getUsers(final String user){
        return userMapper.toDtos(userRepository.findByNameContainsOrderByNameAsc(user));
    }

    public List<UserDto> getUsers(){
        return userMapper.toDtos(userRepository.findAllByOrderByNameAsc());
    }

    public UserDto getUser(final String user){
        return userMapper.toDto(userRepository.findByName(user));
    }

    public UserDto createUser(final UserDto userDto) {
        User user = User.builder()
                .phone(userDto.getPhone())
                .name(userDto.getName())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .city(userDto.getCity())
                .zip(userDto.getZip())
                .build();
        return saveUser(user);
    }



    public UserDto updateUser(final UserDto userDto ){
        User user = User.builder()
                .id(userDto.getId())
                .phone(userDto.getPhone())
                .name(userDto.getName())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .city(userDto.getCity())
                .zip(userDto.getZip())
                .build();
        return saveUser(user);
    }
    private UserDto saveUser(User user) {
        UserDto userDto = userMapper.toDto(userRepository.save(user));
        log.debug("Created user: {}", userDto.getName());
        return userDto;
    }*/
}