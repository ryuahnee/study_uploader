package com.clovasentiment.test.file.factory;

import com.clovasentiment.test.file.dto.TestDataDto;
import com.clovasentiment.test.file.entity.TestDataEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TestDataResponseFactory {
    public static List<TestDataDto> create(List<TestDataEntity> testEntities) {
        // Entity 리스트를 DTO 리스트로 변환
        return testEntities.stream()
                .map(entity -> TestDataDto.builder()
                        .id(entity.getId())
                        .isssueKey(entity.getIssueKey())
                        .indate(entity.getIndate())
                        .issueStatus(entity.getIssueStatus())
                        .build())
                .collect(Collectors.toList());
    }
}
