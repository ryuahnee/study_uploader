package com.clovasentiment.test.apitest.repository;

import com.clovasentiment.test.apitest.entity.DeskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends JpaRepository<DeskEntity, Long> {

}
