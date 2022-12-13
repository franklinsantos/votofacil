package com.fsantos.votofacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsantos.votofacil.dto.ApuracaoResponseDto;
import com.fsantos.votofacil.messenger.Produtor;

@Service
public class MensagemService {

    private final Produtor producer;

    @Autowired
    public MensagemService(Produtor producer) {
        this.producer = producer;
    }


    public void enviar(ApuracaoResponseDto apuracaoResponseDto) {
        producer.enviar(String.format("Pauta '%s' fechada! Votos: [Sim= %d] ~ [Nao= %d]",
           apuracaoResponseDto.getPauta().getTitulo(),
           apuracaoResponseDto.getTotalSim(),
           apuracaoResponseDto.getTotalNao()
        ));
    }
}
