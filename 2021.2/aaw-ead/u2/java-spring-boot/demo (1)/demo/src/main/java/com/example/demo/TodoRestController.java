package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.domain.Todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
    
    private Map<Integer, Todo> todos = new HashMap<>();

    private static int id = 0;

    @GetMapping("/todos")
    public Map<Integer, Todo> getAll() {
        return todos;
    } 

    @PostMapping("/todos")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Todo create(@RequestBody Todo value) {
        System.out.println("create: " + value);
        id++;
        value.setId(id);
        todos.put(id, value);

        System.out.println(todos);

        return value;
    }

    @GetMapping("/todos/{id}")
    public Todo getOne(@PathVariable Integer id) {
        if (!todos.containsKey(id)) {
            throw new ResourceNotFoundException();
        }

        return todos.get(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException() {
        throw new ResourceNotFoundException();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    class ResourceNotFoundException extends RuntimeException {
    }
}
