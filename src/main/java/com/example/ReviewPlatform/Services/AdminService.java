package com.example.ReviewPlatform.Services;

import com.example.ReviewPlatform.Models.AdminUser;
import com.example.ReviewPlatform.Repos.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepo repo;

    public boolean signup(String username, String password) {
        repo.save(new AdminUser(username, password));
        return true;
    }
}
