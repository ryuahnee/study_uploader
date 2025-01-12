package com.clovasentiment.test.file.service;

import com.clovasentiment.test.file.dto.TestDataDto;
import com.clovasentiment.test.file.entity.TestDataEntity;
import com.clovasentiment.test.file.excel.ExcelDownLoader;
import com.clovasentiment.test.file.factory.TestDataResponseFactory;
import com.clovasentiment.test.file.repository.TestDataRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Slf4j
@Service
public class ExcelService {

   private final TestDataRepository testDataRepository;
   private final ExcelDownLoader excelDownLoader;

    public ExcelService(TestDataRepository testDataRepository, ExcelDownLoader excelDownLoader) {
        this.testDataRepository = testDataRepository;
        this.excelDownLoader = excelDownLoader;
    }

    public void createExcel(HttpServletResponse response) throws IOException {

        // entity에서 데이터 조회
        List<TestDataEntity> testdata = testDataRepository.findAll();

        log.info("testdata={}",testdata);

        // DTO 데이터로 변환함
        List<TestDataDto> data = TestDataResponseFactory.create(testdata);

        log.info("data={}",data.stream().toList());

        excelDownLoader.download(data,response);
    }
}
