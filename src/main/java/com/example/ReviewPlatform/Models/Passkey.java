package com.example.ReviewPlatform.Models;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passkey {
    @Id
    private Long id;
    private UUID token;
}
