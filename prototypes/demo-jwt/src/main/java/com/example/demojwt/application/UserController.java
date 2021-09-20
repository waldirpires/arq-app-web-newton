package com.example.demojwt.application;

import com.example.demojwt.api.UserDto;
import com.example.demojwt.domain.entity.User;
import com.example.demojwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/users")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {

        var user = userService.create(new User(userDto));

        return ResponseEntity.ok(new UserDto(user));
    }

    @PutMapping("/v1/users/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto userDto) {
        var user = userService.update(id, new User(userDto));

        return ResponseEntity.ok(new UserDto(user));
    }

    @GetMapping("/v1/users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        var user = userService.getById(id);

        return ResponseEntity.ok(new UserDto(user));
    }

    @GetMapping("/v1/users")
    public ResponseEntity<List<UserDto>> getAll() {
        var users = userService.getAll();

        var userDtos = new ArrayList<UserDto>();

        for (var user: users) {
            userDtos.add(new UserDto(user));
        }

        return ResponseEntity.ok(userDtos);
    }

    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        userService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
