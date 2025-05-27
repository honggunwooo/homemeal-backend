package com.example.demo.service;

import com.example.demo.entity.Favorite;
import com.example.demo.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    // ✅ 찜 추가
    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    // ✅ 사용자 ID로 찜 목록 조회
    public List<Favorite> getFavoritesByUserId(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    // ✅ 찜 삭제
    public void removeFavorite(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}
