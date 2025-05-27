package com.example.demo.entity;

import jakarta.persistence.*;            // 이거 중요!
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long mealId;
    private LocalDateTime createdAt;
}
