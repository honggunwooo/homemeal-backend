package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "서버 연결 성공!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring!";
    }
}
