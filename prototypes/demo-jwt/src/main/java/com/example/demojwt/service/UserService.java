package com.example.demojwt.service;

import com.example.demojwt.domain.entity.User;
import com.example.demojwt.domain.repository.UserRepository;
import com.example.demojwt.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {

        var now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setModifiedAt(now);

        user = userRepository.save(user);

        return user;
    }

    public User update(Integer id, User user) {
        var existing = getById(id);

        existing.setName(user.getName());
        existing.setPassword(user.getPassword());
        existing.setEmail(user.getEmail());
        existing.setMobile(user.getMobile());

        existing.setModifiedAt(LocalDateTime.now());

        user = userRepository.save(existing);

        return user;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        var user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException("User", id);
        }

        return user.get();
    }

    public void deleteById(Integer id) {
        getById(id);

        userRepository.deleteById(id);
    }
}
