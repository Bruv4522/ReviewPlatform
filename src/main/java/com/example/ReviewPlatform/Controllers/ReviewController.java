package com.example.ReviewPlatform.Controllers;

import com.example.ReviewPlatform.Models.Review;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @GetMapping
    public List<Review> reviews() {
        return null;
    }
}
