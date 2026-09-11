package com.example.ReviewPlatform.Services;

import com.example.ReviewPlatform.Models.AdminUser;
import com.example.ReviewPlatform.Repos.AdminRepo;
import com.example.ReviewPlatform.Repos.TokenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepo repo;
    private final TokenRepo tokens;

    public boolean signup(String username, String password) {
        repo.save(new AdminUser(username, password));
        return true;
    }

    public void login(String username, String password) {}
}
