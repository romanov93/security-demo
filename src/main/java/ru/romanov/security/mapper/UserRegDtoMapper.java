package ru.romanov.security.mapper;

import org.springframework.stereotype.Component;
import ru.romanov.security.dto.UserRegDto;
import ru.romanov.security.entity.User;

@Component
public class UserRegDtoMapper implements ToEntityMapper<User, UserRegDto>{
    @Override
    public User mapToEntity(UserRegDto userRegDto) {
        return User.builder()
                .name(userRegDto.getName())
                .passportNumber(userRegDto.getPassportNumber())
                .password(userRegDto.getPassword())
                .build();
    }
}