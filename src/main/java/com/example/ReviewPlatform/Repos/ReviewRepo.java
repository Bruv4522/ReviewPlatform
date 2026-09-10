package com.example.ReviewPlatform.Repos;

import com.example.ReviewPlatform.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
