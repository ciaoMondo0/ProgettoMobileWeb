package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.model.contenuto.StatoSegnalazioni;
import com.it.unicam.progetto_ids_2023.repository.ContenutoBaseRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import com.it.unicam.progetto_ids_2023.repository.SegnalazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportFactory implements SegnalazioneFactory{
    @Autowired
    private final SegnalazioniRepository segnalazioneRepository;
    private final ContenutoRepository contenutoRepository;

    public ReportFactory(SegnalazioniRepository segnalazioneRepository, ContenutoRepository contenutoBaseRepository){
        this.segnalazioneRepository = segnalazioneRepository;
        this.contenutoRepository = contenutoBaseRepository;
    }
    @Override
    public Segnalazione createSegnalazione(SegnalazioniDTO segnalazioniDTO) {
        Contenuto contenuto = this.contenutoRepository.findById(segnalazioniDTO.ContenutoId()).orElseThrow();


        String testoSegnalazione = segnalazioniDTO.testoSegnalazione();
        StatoSegnalazioni stato = StatoSegnalazioni.PENDING;
        return new Segnalazione(contenuto, testoSegnalazione, stato);
    }
}
