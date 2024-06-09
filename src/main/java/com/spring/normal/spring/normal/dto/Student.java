package com.spring.normal.spring.normal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Student {
    private final String iam = Student.class.getSimpleName();
    private String code;
    private String name;
    private int age;
}
