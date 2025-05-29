package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.dto.MealDto;
import com.example.demo.entity.Meal;
import com.example.demo.service.MealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;
    private final JwtUtil jwtUtil;

    // 🍱 전체 음식 목록 조회
    @PostMapping("/get")
    public ResponseEntity<?> getAllMeals(@RequestHeader("Authorization") String authorizationHeader) {
        try{
            String token = authorizationHeader.replace("Bearer ", "");
            log.info(token);
            if (jwtUtil.validatingToken(token)) {
                return ResponseEntity.status(401).body("Invalid or expired JWT token");
            }

            String parsedUsername = jwtUtil.getNameFromToken(token);
            log.info(parsedUsername);
            List<Meal> meals = mealService.getAllMeals(parsedUsername);
            return ResponseEntity.ok(meals);

        }catch (Exception e){
            return ResponseEntity.badRequest().body("jwt error");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> getMealById(MealDto mealDto,
                                         @RequestHeader("Authorization") String authorizationHeader) {
        try{
            String token = authorizationHeader.replace("Bearer ", "");
            if (jwtUtil.validatingToken(token)) {
                return ResponseEntity.status(401).body("Invalid or expired JWT token");
            }
            log.info(mealDto.getName());
            String parsedUsername = jwtUtil.getNameFromToken(token);
            return mealService.uploadMeal(mealDto, parsedUsername);

        }catch (Exception e){
            return ResponseEntity.badRequest().body("jwt error");
        }
    }
    // 기존 POST /api/meals (음식등록) 메서드는 그대로!
}
