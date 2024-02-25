package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.model.contenuto.StatoSegnalazioni;
import com.it.unicam.progetto_ids_2023.repository.SegnalazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportFactory implements SegnalazioneFactory{
    @Autowired
    private final SegnalazioniRepository segnalazioneRepository;

    public ReportFactory(SegnalazioniRepository segnalazioneRepository){
     this.segnalazioneRepository = segnalazioneRepository;
    }
    @Override
    public Segnalazione createSegnalazione(SegnalazioniDTO segnalazioniDTO) {
        Contenuto contenuto = segnalazioniDTO.contenuto();
        String testoSegnalazione = segnalazioniDTO.testoSegnalazione();
        StatoSegnalazioni stato = segnalazioniDTO.statoSegnalazioni();
        return new Segnalazione(contenuto, testoSegnalazione, stato);
    }
}
