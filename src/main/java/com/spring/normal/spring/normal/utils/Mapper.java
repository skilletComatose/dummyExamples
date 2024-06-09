package com.spring.normal.spring.normal.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ObjectMapper objectMapper;

    public Optional<Object> toClassWithMatch(String json, List<ClassMatcherPredicate<?>> options) {
        return toJsonNode(json)
                .flatMap(jsonNode -> toClassWithMatch(jsonNode, options));
    }

    public Optional<Object> toClassWithMatch(JsonNode jsonNode, List<ClassMatcherPredicate<?>> options) {

        return options.stream()
                .filter(validator -> validator.match(jsonNode))
                .findFirst()
                .flatMap(matcher -> mapToClass(jsonNode, matcher.targetClass()));
    }

    public <T> Optional<T> mapToClass(Object object, Class<T> targetClass) {
        return Optional.ofNullable(object)
                .map(obj -> objectMapper.convertValue(obj, targetClass));
    }

    public Optional<JsonNode> toJsonNode(String data) {
        try {
            return Optional.of(objectMapper.readTree(data));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

}
