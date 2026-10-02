package org.example.kafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private Logger logger= LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "appointment_created_topic",groupId = "notification-group")

    public void consumerAppointmentCreated(String message) {
        logger.info(
                "Received appointment notification: "+ message);
    }
}
