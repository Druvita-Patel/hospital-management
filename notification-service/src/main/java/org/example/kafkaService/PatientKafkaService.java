package org.example.kafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PatientKafkaService {
    private Logger logger= LoggerFactory.getLogger(PatientKafkaService.class);

    @KafkaListener (topics="patient_created",groupId = "notification-group")

    public void consumer(String message){
        logger.info("Message created:"+ message);
    }

}
