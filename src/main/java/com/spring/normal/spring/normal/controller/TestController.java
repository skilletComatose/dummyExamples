package com.spring.normal.spring.normal.controller;


import com.spring.normal.spring.normal.utils.Mapper;
import com.spring.normal.spring.normal.utils.MatchingOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/functional-strategies")
@RequiredArgsConstructor
public class TestController {

    private final Mapper mapper;
    @PostMapping("/parse")
    public ResponseEntity<Object> manageMultipleObjectOptions(@RequestBody String value ){
        return ResponseEntity.ok(
                mapper.toClassWithMatch(value, MatchingOptions.CLASS_MATCHER_PREDICATE_LIST)
                        .orElse(Map.of("msg", "the request couldn't be mapped  "))
        );
    }
}
