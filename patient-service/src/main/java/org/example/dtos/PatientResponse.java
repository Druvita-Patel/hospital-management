package org.example.dtos;

import java.time.LocalDate;

public record PatientResponse(Long id, String firstName, String lastName, String email, String phone, LocalDate dateOfBirth,String address) {
}
