package org.example.service;

import org.example.config.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

     private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    private Logger logger= LoggerFactory.getLogger(KafkaService.class);

    public void sendAppointmentCreatedMessage(Long appointmentId,Long patientId,Long doctorId){
    String message="Appointment ID:"+appointmentId +","+ "Patient ID:" +patientId +","+ "Doctor ID;"+doctorId;

    kafkaTemplate.send(AppConstant.APPOINTMENT_CREATED,message);
    logger.info("Appointment event sent to kafka" +message);
    }
}
