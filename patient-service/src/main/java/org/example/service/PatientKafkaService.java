package org.example.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class PatientKafkaService {

    private static final String PATIENT_CREATED_TOPIC_NAME="patient_created";

    private final KafkaTemplate<String,String> kafkaTemplate;

    public PatientKafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageCreate(String message){
        kafkaTemplate.send(PATIENT_CREATED_TOPIC_NAME,message);
    }
    public void sendMessageUpdate(String message){
        kafkaTemplate.send(PATIENT_CREATED_TOPIC_NAME,message);
    }
}
