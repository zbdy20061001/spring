package com.example.demo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class User {
    @NotNull
    @Size(min = 5, message = "Name must be at least 4 characters long")
    private String username;
    @NotNull
    @Size(min = 5, message = "Name must be at least 4 characters long")
    private String password;
}
