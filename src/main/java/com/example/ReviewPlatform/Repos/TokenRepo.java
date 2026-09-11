package com.example.ReviewPlatform.Repos;

import com.example.ReviewPlatform.Models.SessionToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<SessionToken, Long> {
    void deleteByValidFalse();
}
