package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "meals")
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private UserEntity seller;

    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private String category;
    private LocalDateTime createdAt;

    // 생성자, Getter/Setter

    public Meal(UserEntity seller, String name, String description, Integer price,
                String imageUrl, String category, LocalDateTime createdAt) {
        this.seller = seller;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
        this.createdAt = createdAt;
    }
}
