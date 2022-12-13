package com.fsantos.votofacil.messenger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumidor
{

    private final KafkaTemplate kafkaTemplate;
    Logger logger = LoggerFactory.getLogger(Consumidor.class);

    @Autowired
    public Consumidor(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "${votofacil.apuracao.kafka.topico}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String mensagem) {
        logger.info(mensagem);
    }

}
