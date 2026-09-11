package com.example.ReviewPlatform.Repos;

import com.example.ReviewPlatform.Models.Passkey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepo extends JpaRepository<Passkey, Long> {
}
