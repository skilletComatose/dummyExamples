package com.spring.normal.spring.normal.utils;

import com.fasterxml.jackson.databind.JsonNode;

@FunctionalInterface
public interface ClassValidator< T extends JsonNode, R > {
     boolean isValidClass(T jsonNode, Class<R> targetClass);
}
