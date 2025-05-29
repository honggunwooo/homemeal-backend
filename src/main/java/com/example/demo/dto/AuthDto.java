package com.example.demo.dto;

import com.example.demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class AuthDto {

    @Getter
    @Setter
    @Builder
    public static class SignUpDto {
        private String username;
        private String password;
        private String nickname;
        private String region;
        private String role;

        public UserEntity toUser() {
            return UserEntity.builder()
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .region(region)
                    .role(role)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class LoginDto {
        private String username;
        private String password;
    }

    @Getter
    @Setter
    public static class ResponseDto {
        private String message;

        public ResponseDto(String message) {
            this.message = message;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class TokenResponseDto {
        private String message;
        private String token;
    }

}
