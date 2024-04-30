package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.model.contenuto.StatoSegnalazioni;
import com.it.unicam.progetto_ids_2023.repository.ContenutoBaseRepository;
import com.it.unicam.progetto_ids_2023.repository.SegnalazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportFactory implements SegnalazioneFactory{
    @Autowired
    private final SegnalazioniRepository segnalazioneRepository;
    private final ContenutoBaseRepository contenutoBaseRepository;

    public ReportFactory(SegnalazioniRepository segnalazioneRepository, ContenutoBaseRepository contenutoBaseRepository){
     this.segnalazioneRepository = segnalazioneRepository;
     this.contenutoBaseRepository = contenutoBaseRepository;
    }
    @Override
    public Segnalazione createSegnalazione(SegnalazioniDTO segnalazioniDTO) {
        ContenutoBase contenuto = this.contenutoBaseRepository.findById(segnalazioniDTO.ContenutoId()).orElseThrow();


        String testoSegnalazione = segnalazioniDTO.testoSegnalazione();
        StatoSegnalazioni stato = StatoSegnalazioni.PENDING;
        return new Segnalazione(contenuto, testoSegnalazione, stato);
    }
}
