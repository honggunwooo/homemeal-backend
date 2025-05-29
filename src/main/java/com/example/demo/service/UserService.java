package com.example.demo.service;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.AuthDto;
import com.example.demo.entity.UserEntity;
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
        UserEntity userEntity = signUpDto.toUser();
        log.info("회원가입 요청: {}", userEntity.getUsername());
        userRepository.save(userEntity);
        return ResponseEntity.ok().body(new AuthDto.ResponseDto("회원가입 완료"));
    }

    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return ResponseEntity.ok().body(userEntityList);
    }

    public ResponseEntity<?> login(AuthDto.LoginDto loginDto) {
        UserEntity userEntity = userRepository.findByUsername(loginDto.getUsername());

        if (userEntity == null) {
            return ResponseEntity.status(401).body(new AuthDto.ResponseDto("User not found"));
        }

        if (!userEntity.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.status(401).body(new AuthDto.ResponseDto("Invalid password"));
        }

        String token = jwtUtil.generateToken(userEntity.getUsername());

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body(new AuthDto.TokenResponseDto("Login success", token));
    }

    // ⭐️ JwtFilter에서 사용할 메서드 (Optional 대응)
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
