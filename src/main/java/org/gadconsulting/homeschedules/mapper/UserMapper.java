package org.gadconsulting.homeschedules.mapper;

import org.gadconsulting.homeschedules.dto.UserDto;
import org.gadconsulting.homeschedules.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtos(List<User> users);

    List<User> toEntitys(List<UserDto> users);
}
