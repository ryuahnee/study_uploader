package com.clovasentiment.test.dsl.repository;

import com.clovasentiment.test.dsl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {

}
