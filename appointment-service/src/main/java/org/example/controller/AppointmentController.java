package org.example.controller;

import jakarta.validation.Valid;
import org.example.entities.AppointmentEntity;
import org.example.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")

public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping
    public List<AppointmentEntity> getAppointment(){
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/{id}")
    public AppointmentEntity getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentEntity saveAppointment(@Valid @RequestBody AppointmentEntity appointment){
        return appointmentService.saveAppointment(appointment);
    }

    @PutMapping("/{id}")
    public AppointmentEntity updateAppointment(@PathVariable Long id, @Valid @RequestBody AppointmentEntity appointment){
        return appointmentService.updateAppointment(id,appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
    }
}
