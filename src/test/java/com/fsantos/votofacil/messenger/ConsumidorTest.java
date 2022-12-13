package com.fsantos.votofacil.messenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;

class ConsumidorTest
{

   @Mock
   KafkaTemplate kafkaTemplate;
   @Mock
   Logger logger;
   @InjectMocks
   Consumidor consumidor;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testConsume()
   {
      consumidor.consume("message");
   }
}
