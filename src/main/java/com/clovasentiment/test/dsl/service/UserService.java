package com.clovasentiment.test.dsl.service;

import com.clovasentiment.test.dsl.entity.UserEntity;
import com.clovasentiment.test.dsl.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsersByAgeGreaterThan(int age) {
        return userRepository.findUsersByAgeGreaterThan(age);
    }
}
