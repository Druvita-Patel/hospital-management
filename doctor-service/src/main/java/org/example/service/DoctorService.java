package org.example.service;

import org.example.entities.DoctorEntity;
import org.example.exception.ResourceNotFoundException;
import org.example.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorEntity> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public DoctorEntity getOneDoctor(Long id){
        return doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor not found"));
    }

    public DoctorEntity save(DoctorEntity doctor){
        return doctorRepository.save(doctor);
    }

    public DoctorEntity updateDoctor(Long id,DoctorEntity doctor){
        DoctorEntity newDoctor=getOneDoctor(id);

        newDoctor.setFirstName(doctor.getFirstName());
        newDoctor.setLastName(doctor.getLastName());
        newDoctor.setPhone(doctor.getPhone());
        newDoctor.setSpecialization(doctor.getSpecialization());

        return doctorRepository.save(newDoctor);

    }

    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);

    }




}
