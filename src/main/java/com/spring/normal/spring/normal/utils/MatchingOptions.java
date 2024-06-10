package com.spring.normal.spring.normal.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.normal.spring.normal.dto.Book;
import com.spring.normal.spring.normal.dto.Product;
import com.spring.normal.spring.normal.dto.Student;

import java.util.List;


public class MatchingOptions {

    public static final List<ClassMatcherPredicate<?, JsonNode>> CLASS_MATCHER_PREDICATE_LIST = List.of(
            new ClassMatcherPredicate<>(Book.class, jsonNode -> jsonNode.has("author")),
            new ClassMatcherPredicate<>(Product.class, jsonNode -> jsonNode.has("price")),
            new ClassMatcherPredicate<>(Student.class, jsonNode -> jsonNode.has("age")));

    private MatchingOptions() {
    }
}
