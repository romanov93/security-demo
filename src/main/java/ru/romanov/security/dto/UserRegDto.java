package ru.romanov.security.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@Builder
@Getter
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserRegDto {
    String name;
    String password;
    String passportNumber;
}