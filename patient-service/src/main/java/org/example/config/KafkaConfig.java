package org.example.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {


        @Bean
        public KafkaTemplate<String, String> kafkaTemplate() {

            Map<String, Object> config = new HashMap<>();

            config.put("bootstrap.servers", "localhost:9092");
            config.put("key.serializer", StringSerializer.class);
            config.put("value.serializer", StringSerializer.class);

            return new KafkaTemplate<>(
                    new DefaultKafkaProducerFactory<>(config)
            );
        }
    }

