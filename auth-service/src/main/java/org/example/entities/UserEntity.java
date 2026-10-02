package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="users")
    public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "UserName is required")
        @Size(min=2,max=50,message ="Min 2 and Max 50 Characters required")
        @Column(nullable = false,unique = true,length = 5)
        private String username;

        @NotBlank(message = "Password is required")
        @Column(nullable = false)
        private String password;

        private String role;

    }


