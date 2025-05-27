package com.example.demo.dto;

import com.example.demo.entity.Favorite;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FavoriteDto {
    private Long mealId;
    private Long userId;

    public Favorite toEntity() {
        return Favorite.builder()
                .mealId(this.mealId)
                .userId(this.userId)
                .build();
    }
}
