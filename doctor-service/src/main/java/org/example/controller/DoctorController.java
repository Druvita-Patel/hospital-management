package org.example.controller;

import jakarta.validation.Valid;
import org.example.entities.DoctorEntity;
import org.example.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorEntity> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorEntity getOneDoctor(@PathVariable Long id){
        return doctorService.getOneDoctor(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorEntity saveDoctor(@Valid @RequestBody DoctorEntity doctor){
        return  doctorService.save(doctor);
    }

    @PutMapping("/{id}")
    public DoctorEntity updateDoctor(@PathVariable Long id,@Valid @RequestBody DoctorEntity doctor){
        return doctorService.updateDoctor(id,doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }

}
