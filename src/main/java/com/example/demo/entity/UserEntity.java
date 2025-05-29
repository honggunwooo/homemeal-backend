    package com.example.demo.entity;

    import jakarta.persistence.*;
    import lombok.*;

    @Builder
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "user_table")
    public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String password;
        private String nickname;
        private String region;
        private String role;

    }
