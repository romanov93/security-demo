package ru.romanov.security.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.romanov.security.configuration.UserDetailsImpl;
import ru.romanov.security.entity.User;

import java.util.Optional;

@Service
@ToString
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> maybeUser = userService.findByName(username);

        return maybeUser.map(UserDetailsImpl::new).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with name \"%s\" not found", username))
        );
    }
}
