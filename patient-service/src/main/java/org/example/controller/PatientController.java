package org.example.controller;

import jakarta.validation.Valid;
import org.example.entities.PatientEntity;
import org.example.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

        private final PatientService patientService;

        public PatientController(PatientService patientService) {
            this.patientService = patientService;
        }

        @GetMapping
        public List<PatientEntity> all(){
            return patientService.getAll();
        }

        @GetMapping("/{id}")
        public PatientEntity getByPatientId(@PathVariable Long  id){
            return patientService.getByPatientId(id);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public PatientEntity createPatient(@Valid @RequestBody PatientEntity patientEntity){
            return patientService.createPatient(patientEntity);
        }


        @PutMapping("/{id}")
        public PatientEntity updatePatient(@Valid @PathVariable Long id, @Valid @RequestBody PatientEntity patientEntity){
            return patientService.updatePatient(id,patientEntity);
        }

        @DeleteMapping("/{id}")
        public void delete(Long id){
            patientService.deletePatient(id);
        }

    }



