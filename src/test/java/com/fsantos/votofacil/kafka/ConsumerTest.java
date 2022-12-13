package com.fsantos.votofacil.kafka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

class ConsumerTest
{

   @Mock
   KafkaTemplate kafkaTemplate;
   @Mock
   Logger logger;
   @InjectMocks
   Consumer consumer;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testConsume()
   {
      consumer.consume("message");
   }
}
