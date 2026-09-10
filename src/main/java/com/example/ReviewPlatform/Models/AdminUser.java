package com.example.ReviewPlatform.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @NotNull
    @NotBlank
    private String password;

    public AdminUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

// Remember what you were doing
// You were building an AdminUser system, and now you need to build another SessionToken model that links to an AdminUser by foreign key
// It expires by a timestamp that uses the Instant class, storing createdAt and then that Instant.plus(24, ChronoUnit.HOURS)
// Then you create a service that uses CRON scheduling to periodically delete invalid tokens every 6 hours
// Remember, you are building this to be used by one company as proof of existence is too difficult
// It is a backend that if developed beyond the MVP to production-grade will be sold to a small company
// You have to learn React and build a frontend too
// Godspeed