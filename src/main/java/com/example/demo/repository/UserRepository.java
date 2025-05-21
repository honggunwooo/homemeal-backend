package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // (선택) username으로 회원 찾는 메서드
    User findByUsername(String username);
}
