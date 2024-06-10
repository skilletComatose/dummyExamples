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


    public <R> Optional<Object> toClassWithMatch(R target, List<ClassMatcherPredicate<?, R>> options) {

        return options.stream()
                .filter(validator -> validator.match(target))
                .findFirst()
                .flatMap(matcher -> mapToClass(target, matcher.targetClass()));
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
