package com.example.ReviewPlatform.Controllers;

import com.example.ReviewPlatform.Models.Message;
import com.example.ReviewPlatform.Models.SignupBody;
import com.example.ReviewPlatform.Services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService service;

    @PostMapping("/signup")
    public Message signup(@RequestBody SignupBody body) {
        if (!service.signup(body.getDetails().getUsername(), body.getDetails().getPassword(), body.getToken())) {
            return new Message("Admin failed to signup, invalid token");
        }

        return new Message("Admin signed up successfully");
    }
}
