package com.example.ReviewPlatform.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String body;
    private boolean adminFlagged = false;
    private boolean aiFlagged = false;
    private ReviewStatus status = ReviewStatus.SENT;

    public Review(int rating, String title, String body) {
        this.rating = rating;
        this.title = title;
        this.body = body;
    }
}
