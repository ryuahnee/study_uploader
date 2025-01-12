package com.clovasentiment.test.file.dto;

public enum TestDataHeader {
    id("ID"),
    isssueKey("이슈키"),
    indate("생성일"),
    issueStatus("상태");

    private final String headerName;


    TestDataHeader(String headerName) {
        this.headerName = headerName;
    }

    public String getHeaderName(){
        return headerName;
    }
}
