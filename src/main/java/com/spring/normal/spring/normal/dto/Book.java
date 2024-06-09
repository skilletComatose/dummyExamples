package com.spring.normal.spring.normal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Book {
    private final String iam = Book.class.getSimpleName();
    private String title;
    private String author;
}
