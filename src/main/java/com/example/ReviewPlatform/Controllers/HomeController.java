package com.example.ReviewPlatform.Controllers;

import com.example.ReviewPlatform.Models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public Message home() {
        return new Message("This is the Review Platform API");
    }
}
