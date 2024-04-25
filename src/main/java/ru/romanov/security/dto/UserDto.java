package ru.romanov.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@Builder
@Getter
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserDto {
    String name;
    String passportNumber;
}