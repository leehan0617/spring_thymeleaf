package com.example.demo.service;

import com.example.demo.mapper.SampleMapper;
import com.example.demo.model.Sample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleMapper sampleMapper;

    public Sample save(Sample sample) {
        sampleMapper.insert(sample);
        return sample;
    }

    public Sample findById(int id) {
        return sampleMapper.findById(id);
    }

    public List<Sample> findAll() {
        return sampleMapper.findAll();
    }

    public Sample update(Sample sample) {
        sampleMapper.update(sample);
        return sample;
    }

    public void delete(int id) {
        sampleMapper.delete(id);
    }
}
