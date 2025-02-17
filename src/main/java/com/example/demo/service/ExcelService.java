package com.example.demo.service;

import com.example.demo.mapper.ExcelExampleMapper;
import com.example.demo.model.ExcelExample;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelService {

    private final ExcelExampleMapper excelExampleMapper;

    public InputStreamResource getExcelExampleFile() throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("목록");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("NAME");
            header.createCell(2).setCellValue("EMAIL");
            header.createCell(3).setCellValue("AGE");
            header.createCell(4).setCellValue("ADDRESS");

            List<ExcelExample> list = excelExampleMapper.findAll();
            for (ExcelExample excelExample : list) {
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(excelExample.getId());
                row.createCell(1).setCellValue(excelExample.getName());
                row.createCell(2).setCellValue(excelExample.getEmail());
                row.createCell(3).setCellValue(excelExample.getAge());
                row.createCell(4).setCellValue(excelExample.getAddress());
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            return new InputStreamResource(inputStream);
        }
    }

    public void uploadExcel(MultipartFile file) throws IOException{
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                ExcelExample excelExample = new ExcelExample();
                excelExample.setName(row.getCell(1).getStringCellValue());
                excelExample.setEmail(row.getCell(2).getStringCellValue());
                excelExample.setAge((int)row.getCell(3).getNumericCellValue());
                excelExample.setAddress(row.getCell(4).getStringCellValue());
                excelExampleMapper.insert(excelExample);
            }
        }
    }
}
