package org.gadconsulting.homeschedules.service;

import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.model.User;
import org.gadconsulting.homeschedules.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock
    private UserRepository userRepositoryMock;
    @Captor
    private ArgumentCaptor<User> userCaptor;
    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {
        final UserDto userDto = new UserDto();
        userService.createUser(userDto);
        verify(userRepositoryMock).save(userCaptor.capture());

        User user = userCaptor.getValue();
        assertThat(user.getName()).isEqualTo(userDto.getName());

    }
}