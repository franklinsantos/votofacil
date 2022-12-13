package com.fsantos.votofacil.messenger;

import java.util.UUID;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Produtor
{

    @Value("${votofacil.apuracao.kafka.topico}")
    private String kafkaTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Produtor(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(String message) {
        kafkaTemplate.send(new ProducerRecord<>(kafkaTopic, UUID.randomUUID().toString(), message));
    }
}
