package com.example.ReviewPlatform.Models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class SessionToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID token;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true)
    private AdminUser user;
    private boolean valid = true;
    private final Instant createdAt = Instant.now();
    private final Instant expiresAt = createdAt.plus(3, ChronoUnit.HOURS);
    private Instant revokedAt;

    private boolean isValid() {
        return revokedAt == null && Instant.now().isBefore(expiresAt);
    }

    @PrePersist
    private void generateToken() {
        if (token == null) {
            token = UUID.randomUUID();
        }
    }

    @Async
    @Transactional
    @Scheduled(cron = "0 0 */6 * * *")
    public void checkValid() {
        if (!this.isValid()) {
            valid = false;
        }
    }
}

