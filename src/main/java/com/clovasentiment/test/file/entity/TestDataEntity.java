package com.clovasentiment.test.file.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "TEST")
public class TestDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // IDENTITY 대신 AUTO 사용
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ISSUE_KEY")
    private String IssueKey;

    @Column(name = "INDATE")
    private LocalDateTime indate;

    @Column(name = "ISSUE_STATUS")
    private String IssueStatus;

    public TestDataEntity() {
    }

    @Builder
    public TestDataEntity(Integer id, String issueKey, String issueStatus) {
        this.id = id;
        IssueKey = issueKey;
        IssueStatus = issueStatus;
    }
}
