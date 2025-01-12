package com.clovasentiment.test.file.excel;

import com.clovasentiment.test.file.dto.TestDataDto;
import com.clovasentiment.test.file.dto.TestDataHeader;
import com.clovasentiment.test.file.factory.DateFormatterUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
public class ExcelDownLoader {

    public void download(List<TestDataDto> data, HttpServletResponse response) throws IOException {
        // Excel 워크북 생성
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Status Counts");


        // 첫 번째 DTO 객체로 헤더 생성
        Field[] fields = TestDataDto.class.getDeclaredFields();

        log.info("fields : ",fields);


        // 헤더 작성
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName(); // 필드 이름을 ENUM의 이름과 매칭
            log.info("fieldName ?  : " + fieldName);
            String headerName = TestDataHeader.valueOf(fieldName).getHeaderName(); // Enum에서 매핑된 헤더명 가져오기
            Cell cell = headerRow.createCell(i);

            cell.setCellValue(headerName);
        }


        // 데이터 작성
        int rowIdx = 1;
        for (TestDataDto dto : data) {
            Row row = sheet.createRow(rowIdx++);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Cell cell = row.createCell(i);
                try {
                    Object value = fields[i].get(dto);

                    if (fields[i].getName().equals("indate") && value instanceof LocalDateTime) {
                        value = DateFormatterUtil.formatDate((LocalDateTime) value);
                    }

                    cell.setCellValue(value != null ? value.toString() : "");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("엑셀 데이터를 작성하는 중 오류 발생", e);
                }
            }
        }


        // Content-Type 설정
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"status_counts.xlsx\"");

        // Excel 파일 출력
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
