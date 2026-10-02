package org.example.dtos;

public record AuthResponse( String token,
                            String username,
                            String role) {
}
