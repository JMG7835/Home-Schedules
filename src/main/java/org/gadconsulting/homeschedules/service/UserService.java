package org.gadconsulting.homeschedules.service;

import lombok.extern.slf4j.Slf4j;
import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.model.User;
import org.gadconsulting.homeschedules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void createUser(final UserDto userDto) {

        final User user = User.builder()
                .phone(userDto.getPhone())
                .name(userDto.getName())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .city(userDto.getCity())
                .zip(userDto.getZip())
                .build();
        userRepository.save(user);
        log.debug("Created user: {}", user.getId());
    }
}