package org.gadconsulting.homeschedules.service;

import org.gadconsulting.homeschedules.application.service.UsersService;
import org.gadconsulting.homeschedules.adapter.in.dto.UserDto;
import org.gadconsulting.homeschedules.adapter.in.mapper.UserMapper;
import org.gadconsulting.homeschedules.domain.model.User;
import org.gadconsulting.homeschedules.domain.ports.out.repository.UserRepository;
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
class UserServiceTest {

    public static final String TOTO = "TOTO";
    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private UserMapper userMapper;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @InjectMocks
    private UsersService userService;

    @Test
    public void testCreateUser() {
        when(userRepositoryMock.save(any())).thenReturn(new User());
        when(userMapper.toDto(any())).thenReturn(new UserDto());
        when(userMapper.toEntity(any())).thenReturn(new User());

        userService.createUserOrUpdate(new UserDto());

        verify(userRepositoryMock, times(1)).save(userCaptor.capture());
    }

    @Test
    public void testGetUsers_findByString() {
        userService.getUsers(TOTO);
        verify(userRepositoryMock, times(1)).findByNameContainsOrderByNameAsc(anyString());
    }

    @Test
    public void testGetUsers_findAll() {
        userService.getUsers();
        verify(userRepositoryMock, times(1)).findAllByOrderByNameAsc();
    }

    @Test
    public void getUser_findByName() {
        userService.getUser(TOTO);
        verify(userRepositoryMock, times(1)).findByName(anyString());
    }
}