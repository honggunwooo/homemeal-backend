package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class MealDto {
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private String category;

    // Getter/Setter


}
