package org.example.service;

import io.jsonwebtoken.Jwts;
import org.example.entities.UserEntity;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey secretKey;
    public JwtService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }
    public String generateToken(UserEntity user){
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("role",user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000L*60*60))
                .signWith(secretKey)
                .compact();

    }


}

