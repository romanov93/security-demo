package ru.romanov.security.mapper;

import org.springframework.stereotype.Component;
import ru.romanov.security.dto.UserDto;
import ru.romanov.security.entity.User;

@Component
public class UserDtoMapper implements ToDtoMapper<User, UserDto> {

    @Override
    public UserDto mapToDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .passportNumber(user.getPassportNumber())
                .build();
    }
}