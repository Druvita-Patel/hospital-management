package org.example.service;


import org.example.entities.PatientEntity;
import org.example.exception.ResourceNotFoundException;
import org.example.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientEntity> getAll(){
        return patientRepository.findAll();
    }

    public PatientEntity getByPatientId(Long id){
        return patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient not found with id: "+id));
    }


    public PatientEntity createPatient(PatientEntity patientEntity){
        return  patientRepository.save(patientEntity);
    }


    public PatientEntity updatePatient(Long id, PatientEntity patientEntity){
        PatientEntity newPatient=getByPatientId(id);
        newPatient.setFirstName(patientEntity.getFirstName());
        newPatient.setLastName(patientEntity.getLastName());
        newPatient.setEmail(patientEntity.getEmail());
        newPatient.setPhone(patientEntity.getPhone());
        newPatient.setAddress(patientEntity.getAddress());

        return patientRepository.save(newPatient);
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}
