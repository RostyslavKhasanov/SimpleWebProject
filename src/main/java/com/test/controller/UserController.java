package com.test.controller;

import com.test.entity.UserEntity;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("age")
    public ResponseEntity<?> getUsersByAge(
            @RequestParam("number") int number
    ) {
        List<UserEntity> users = userService.findByAgeAfterNumber(number);
        return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
    }

    @GetMapping("article")
    public ResponseEntity<?> getUsersByArticles(
    ) {
        List<String> users = userService.findUsersByCountOfArticles();
        return new ResponseEntity<List<String>>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserEntity user) {
        userService.save(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}