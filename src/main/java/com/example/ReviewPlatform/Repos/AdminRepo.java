package com.example.ReviewPlatform.Repos;

import com.example.ReviewPlatform.Models.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminUser, Long> {
}
