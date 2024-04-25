package ru.romanov.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.romanov.security.dto.UserDto;
import ru.romanov.security.dto.UserRegDto;
import ru.romanov.security.entity.User;
import ru.romanov.security.mapper.UserDtoMapper;
import ru.romanov.security.mapper.UserRegDtoMapper;
import ru.romanov.security.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final UserDtoMapper userDtoMapper;

    private final UserRegDtoMapper userRegDtoMapper;

    @PostMapping("/create")
    public String addUser(@RequestBody UserRegDto userRegDto) {
        System.out.println(userRegDto);
        userService.save(userRegDtoMapper.mapToEntity(userRegDto));
        return "User was saved";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserDto> getAllUsers() {
        return userDtoMapper.mapToDtoList(userService.findAll());
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserDto getUserByName(@PathVariable String name) {
        User user = userService.findByName(name).orElseThrow(() -> new UsernameNotFoundException("Юзер не найден"));
        return userDtoMapper.mapToDto(user);
    }

    @GetMapping("/current")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserDto getCurrentUser() {
        User user = userService.findCurrentUser().orElseThrow(() -> new UsernameNotFoundException("Юзер не найден"));
        return userDtoMapper.mapToDto(user);
    }
}