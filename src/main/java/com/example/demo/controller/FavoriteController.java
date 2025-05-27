package com.example.demo.controller;

import com.example.demo.dto.FavoriteDto;
import com.example.demo.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/add")
    public String addFavorite(@RequestBody FavoriteDto dto) {
        favoriteService.addFavorite(dto.toEntity());
        return "ok";
    }
}