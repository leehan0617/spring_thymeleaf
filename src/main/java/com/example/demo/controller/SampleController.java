package com.example.demo.controller;

import com.example.demo.model.Sample;
import com.example.demo.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping
    public List<Sample> getSamples() {
        return sampleService.findAll();
    }

    @GetMapping("/{id}")
    public Sample getSample(@PathVariable int id) {
        return sampleService.findById(id);
    }

    @PostMapping
    public Sample saveSample(@RequestBody Sample sample) {
        return sampleService.save(sample);
    }

    @PutMapping("/{id}")
    public Sample updateSample(@PathVariable int id, @RequestBody Sample sample) {
        return sampleService.update(sample);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSample(@PathVariable int id) {
        sampleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
