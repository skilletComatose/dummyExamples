package com.spring.normal.spring.normal.controller;


import com.spring.normal.spring.normal.utils.Mapper;
import com.spring.normal.spring.normal.utils.MatchingOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/functional-strategies")
@RequiredArgsConstructor
public class TestController {

    private final Mapper mapper;

    @PostMapping("/parse")
    public ResponseEntity<Object> manageMultipleObjectOptions(@RequestBody String value) {
        return mapper.toJsonNode(value)
                .flatMap(jsonNode -> mapper.toClassWithMatch(jsonNode, MatchingOptions.CLASS_MATCHER_PREDICATE_LIST))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body("ERROR"));
    }
}
