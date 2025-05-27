package com.example.demo.controller;

import com.example.demo.dto.AuthDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody AuthDto.SignUpDto signUpDto) {
        log.info("username: {}", signUpDto.getUsername());
        return userService.register(signUpDto);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().body(new AuthDto.ResponseDto("200"));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam String name,
                                  @RequestParam String region) {
        log.info("username: {}", name);
        log.info("region: {}", region);
        return ResponseEntity.ok().body(200);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto.LoginDto loginDto) {
        log.info("username: {}", loginDto.getUsername());
        return userService.login(loginDto);
    }
}
