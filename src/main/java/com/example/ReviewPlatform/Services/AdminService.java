package com.example.ReviewPlatform.Services;

import com.example.ReviewPlatform.Models.AdminUser;
import com.example.ReviewPlatform.Models.Passkey;
import com.example.ReviewPlatform.Repos.AdminRepo;
import com.example.ReviewPlatform.Repos.KeyRepo;
import com.example.ReviewPlatform.Repos.TokenRepo;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepo repo;
    private final TokenRepo tokens;
    private final KeyRepo key;
    private final PasswordEncoder encoder;

    public boolean signup(String username, String password, String passkey) {
        UUID storedToken = key.findById(1L)
                .orElseThrow(NoSuchElementException::new)
                .getToken();

        UUID providedKey;

        try {
            providedKey = UUID.fromString(passkey);
        } catch (IllegalArgumentException e) {
            return false;
        }

        if (!providedKey.equals(storedToken)) {
            return false;
        }

        repo.save(new AdminUser(username, encoder.encode(password)));
        return true;
    }

    public void login(String username, String password) {}

    @Async
    @Scheduled(cron = "0 0 */6 * * *")
    @Transactional
    public void cleanupInvalidTokens() {
        tokens.deleteByValidFalse();
    }

    @PostConstruct
    public void initPasskey() {
        Passkey p = key.findById(1L).orElseGet(() -> {
            Passkey newKey = new Passkey();
            newKey.setId(1L);
            return key.save(newKey);
        });

        if (p.getToken() == null) {
            p.setToken(UUID.randomUUID());
            key.save(p);
        }
    }

}
