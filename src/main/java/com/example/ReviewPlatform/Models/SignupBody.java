package com.example.ReviewPlatform.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class SignupBody {
    private AdminUser details;
    private String token;
}
