package com.example.demo.service;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.AuthDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public ResponseEntity<?> register(AuthDto.SignUpDto signUpDto) {
        User user = signUpDto.toUser();
        log.info("회원가입 요청: {}", user.getUsername());
        userRepository.save(user);
        return ResponseEntity.ok().body(new AuthDto.ResponseDto("회원가입 완료"));
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok().body(userList);
    }

    public ResponseEntity<?> login(AuthDto.LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());

        if (user == null) {
            return ResponseEntity.status(401).body(new AuthDto.ResponseDto("User not found"));
        }

        if (!user.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.status(401).body(new AuthDto.ResponseDto("Invalid password"));
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body(new AuthDto.TokenResponseDto("Login success", token));
    }
}
