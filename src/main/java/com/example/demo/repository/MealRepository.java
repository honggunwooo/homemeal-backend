package com.example.demo.repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    // 필요한 커스텀 쿼리 있으면 추가
    List<Meal> findBySeller(UserEntity seller);

}
