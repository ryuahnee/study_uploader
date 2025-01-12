package com.clovasentiment.test.file.repository;

import com.clovasentiment.test.file.entity.TestDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDataRepository extends JpaRepository<TestDataEntity, Integer> {


}
