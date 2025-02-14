package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sample {
    private int id;
    private String name;
    private boolean useFlag;
    private int sampleNumber;
    private Date createDate;
}
