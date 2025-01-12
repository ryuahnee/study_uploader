package com.clovasentiment.test.file.controller;

import com.clovasentiment.test.file.service.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExcelController {


        private final ExcelService excelService;

        public ExcelController(ExcelService excelService) {
            this.excelService = excelService;
        }

        @GetMapping("/api/excel/download")
        public void downloadExcel(HttpServletResponse response) throws IOException {

            // Excel 파일 생성 및 다운로드
            excelService.createExcel(response);
        }

}
