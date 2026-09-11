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
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepo repo;
    private final TokenRepo tokens;
    private final KeyRepo key;

    public boolean signup(String username, String password, String passkey) {
        if (key.findById((long) 1).orElseThrow(NoSuchElementException::new).getToken().equals(UUID.fromString(passkey))) {
            return false;
        }

        repo.save(new AdminUser(username, password));
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
    public void saveToken() {
        Passkey p = new Passkey();
        p.setId(1L);
        key.save(p);
    }
}
