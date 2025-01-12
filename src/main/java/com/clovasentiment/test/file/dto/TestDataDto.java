package com.clovasentiment.test.file.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TestDataDto {

    private Integer id;
    private LocalDateTime indate;
    private String isssueKey;
    private String issueStatus;

    @Builder
    public TestDataDto(int id, String isssueKey, LocalDateTime indate,String issueStatus) {
        this.id = id;
        this.indate =indate;
        this.isssueKey = isssueKey;
        this.issueStatus = issueStatus;
    }
}
