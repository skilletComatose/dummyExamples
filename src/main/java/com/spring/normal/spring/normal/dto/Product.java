package com.spring.normal.spring.normal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    private final String iam = Product.class.getSimpleName();
    private String code;
    private String name;
    private double price;
}
