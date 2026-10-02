package org.example.service;

import org.example.entities.AppointmentEntity;
import org.example.exception.ResourceNotFoundException;
import org.example.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;
    private final KafkaService kafkaService;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientClient patientClient, DoctorClient doctorClient, KafkaService kafkaService) {
        this.appointmentRepository = appointmentRepository;
        this.patientClient = patientClient;
        this.doctorClient = doctorClient;
        this.kafkaService = kafkaService;
    }

    public List<AppointmentEntity> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    public AppointmentEntity getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment Not Found"));
    }

    public AppointmentEntity saveAppointment(AppointmentEntity appointment) {

        Object patient=patientClient.getPatientById(appointment.getPatientId());
        Object doctor=doctorClient.getDoctorById(appointment.getDoctorId());
        System.out.println("Patient ID: " +patient);
        System.out.println("Doctor Id:" +doctor);

        AppointmentEntity savedAppointment=appointmentRepository.save(appointment);

        kafkaService.sendAppointmentCreatedMessage(savedAppointment.getId(), savedAppointment.getPatientId(), savedAppointment.getDoctorId());
        return savedAppointment;
    }

    public AppointmentEntity updateAppointment(Long id, AppointmentEntity appointment) {

    AppointmentEntity newAppointment = getAppointmentById(id);

        patientClient.getPatientById(appointment.getPatientId());
        doctorClient.getDoctorById(appointment.getDoctorId());

    newAppointment.setPatientId(appointment.getPatientId());
    newAppointment.setDoctorId(appointment.getDoctorId());
    newAppointment.setAppointmentDate(appointment.getAppointmentDate());
    newAppointment.setAppointmentTime(appointment.getAppointmentTime());
    newAppointment.setStatus(appointment.getStatus());

    return appointmentRepository.save(newAppointment);

    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);

    }
}
