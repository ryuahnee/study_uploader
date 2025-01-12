package com.clovasentiment.test.dsl.repository;

import com.clovasentiment.test.dsl.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserEntity> findUsersByAgeGreaterThan(int age);
}
