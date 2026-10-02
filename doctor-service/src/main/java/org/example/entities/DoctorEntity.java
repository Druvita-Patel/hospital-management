package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="doctors")

public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "FirstName is required")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "LastName is required")
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true,length = 12)
    private String phone;

    @Column(nullable = false)
    private String specialization;

    public DoctorEntity() {
    }

    public DoctorEntity(Long id, String firstName, String lastName, String phone, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "FirstName is required") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "FirstName is required") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "LastName is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "LastName is required") String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
