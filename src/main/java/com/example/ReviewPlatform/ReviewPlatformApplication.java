package com.example.ReviewPlatform;

import com.example.ReviewPlatform.Models.Passkey;
import com.example.ReviewPlatform.Repos.KeyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ReviewPlatformApplication {
	static void main(String[] args) {
		SpringApplication.run(ReviewPlatformApplication.class, args);
	}

}
