package com.example.ReviewPlatform.Models;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class SessionToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID token;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true)
    private AdminUser user;
    private final Instant createdAt = Instant.now();
    private final Instant expiresAt = createdAt.plus(3, ChronoUnit.HOURS);
    private Instant revokedAt;

    private boolean isValid() {
        return revokedAt == null && Instant.now().isBefore(expiresAt);
    }
}

