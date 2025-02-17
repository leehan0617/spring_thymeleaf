package com.example.demo.mapper;

import com.example.demo.model.ExcelExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExcelExampleMapper {
    List<ExcelExample> findAll();
    int insert(ExcelExample excelExample);
}
