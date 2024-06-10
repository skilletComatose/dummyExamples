package com.spring.normal.spring.normal.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.function.Predicate;

public record ClassMatcherPredicate<T, R> (Class<T> targetClass, Predicate<R> predicate) {
    public boolean match(R target) {
        return predicate().test(target);
    }
}
