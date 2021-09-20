package com.example.demojwt.service;

import com.example.demojwt.api.TokenDto;
import com.example.demojwt.domain.entity.User;
import com.example.demojwt.domain.repository.UserRepository;
import com.example.demojwt.exceptions.UserNotAuthenticatedException;
import com.example.demojwt.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public TokenDto authenticate(String userName, String password) {
        var user = userRepository.findByName(userName);

        if (user.isEmpty()) {
            // 403
            throw new UserNotFoundException(userName);
        } else if (!user.get().getPassword().equals(password)) {
            // 401
            throw new UserNotAuthenticatedException(userName);
        }

    }
}
