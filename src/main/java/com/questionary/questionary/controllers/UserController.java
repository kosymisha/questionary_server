package com.questionary.questionary.controllers;

import com.questionary.questionary.dto.UserDto;
import com.questionary.questionary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById (@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id.toString()), HttpStatus.OK);
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<?> getUserByEmail (@PathVariable String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> create (@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<?> update (@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.update(userDto), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
