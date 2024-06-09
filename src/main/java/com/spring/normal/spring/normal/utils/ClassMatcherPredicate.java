package com.spring.normal.spring.normal.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.function.Predicate;

public record ClassMatcherPredicate<T> (Class<T> targetClass, Predicate<JsonNode> predicate) {
    public boolean match(JsonNode jsonNode) {
        return predicate().test(jsonNode);
    }
}
