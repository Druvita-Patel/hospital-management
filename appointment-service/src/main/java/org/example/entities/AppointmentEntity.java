package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="appointments")

public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Patient ID is required")
    @Column(nullable = false)
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    @Column(nullable = false)
    private Long doctorId;

    @NotNull
    @Column(nullable = false)
    private LocalDate appointmentDate;

    @NotNull
    @Column(nullable = false)
    private LocalTime appointmentTime;

    @Column(nullable = false)
    private String status;

    public AppointmentEntity() {
    }

    public AppointmentEntity(Long id, Long patientId, Long doctorId, LocalDate appointmentDate, LocalTime appointmentTime, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Long getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull Long patientId) {
        this.patientId = patientId;
    }

    public @NotNull Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(@NotNull Long doctorId) {
        this.doctorId = doctorId;
    }

    public @NotNull LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(@NotNull LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public @NotNull LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(@NotNull LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
