package com.projects.golfmaster.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "users")
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private String email;
    private String passwordHash;
    private boolean enabled = true;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER; // default role

    public enum Role {
        USER,
        ADMIN
    }


}
