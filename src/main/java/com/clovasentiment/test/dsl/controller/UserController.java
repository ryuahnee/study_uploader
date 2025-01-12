package com.clovasentiment.test.dsl.controller;

import com.clovasentiment.test.dsl.entity.UserEntity;
import com.clovasentiment.test.dsl.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserEntity> getUsersByAge(@RequestParam int age) {
        return userService.getUsersByAgeGreaterThan(age);
    }
}
