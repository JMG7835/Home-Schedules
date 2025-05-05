package org.gadconsulting.homeschedules.service;

import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.model.User;
import org.gadconsulting.homeschedules.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDAO userDAOMock;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {
        final UserDto userDto = new UserDto();

        when(userDAOMock.save(any())).thenReturn(new User());

        userService.createUser(userDto);

        verify(userDAOMock, times(1)).save(userCaptor.capture());

        User user = userCaptor.getValue();
        assertThat(user.getName()).isEqualTo(userDto.getName());

    }
}