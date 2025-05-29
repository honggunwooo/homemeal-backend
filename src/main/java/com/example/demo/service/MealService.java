package com.example.demo.service;

import com.example.demo.dto.MealDto;
import com.example.demo.entity.Meal;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.MealRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> uploadMeal(MealDto mealDto, String username) {
        log.info(mealDto.getName());
        log.info(mealDto.getDescription());

        Meal meal = new Meal(
                userRepository.findByUsername(username),
                mealDto.getName(),
                mealDto.getDescription(),
                mealDto.getPrice(),
                mealDto.getImageUrl(),
                mealDto.getCategory(),
                LocalDateTime.now()
        );

        log.info(meal.getName());
        mealRepository.save(meal);
        return ResponseEntity.ok(200);
    }

    // ⭐️ 전체 음식 목록 조회
    public List<Meal> getAllMeals(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        log.info(userEntity.getUsername());
        return mealRepository.findBySeller(userEntity);
    }
}
