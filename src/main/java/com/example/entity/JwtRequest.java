package com.example.entity;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class JwtRequest {
    private String username;
    private String password;
}
