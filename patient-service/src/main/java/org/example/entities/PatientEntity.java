package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="patients")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "First name is required")
    @Column(nullable = false)
    private String firstName;


    @NotBlank(message = "Last name is required")
    @Column(nullable = false)
    private String lastName;


    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message="Phone is required")
    @Column(unique = true,nullable = false,length = 11)
    private String phone;

    private LocalDate dateOfBirth;

    private String address;

}
