package com.example.demo.mapper;

import com.example.demo.model.Sample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    List<Sample> findAll();
    Sample findById(Integer id);
    int insert(Sample sample);
    int update(Sample sample);
    int delete(Integer id);
}
