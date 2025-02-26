package main.java.com.it.unicam.progetto_ids_2023.service;


import main.java.com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.*;
import main.java.com.it.unicam.progetto_ids_2023.model.factory.ReportFactory;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SegnalazioniService {


    private ReportFactory reportFactory;

    private ContenutoMultimedialeRepository multiRepo;

    private ContenutoTestualeRepository testoRepo;

    private ComuneRepository comuneRepo;

    private PuntoDiInteresse punto;




    private SegnalazioniRepository segnalazioneRepo;

    private UtenteRepository utenteRepository;


    @Autowired
    public SegnalazioniService(ContenutoTestualeRepository testoRepo, ContenutoMultimedialeRepository multiRepo, SegnalazioniRepository segnalazioneRepo, ComuneRepository comuneRepo, ReportFactory reportFactory
            , UtenteRepository utenteRepository) {
        this.comuneRepo = comuneRepo;
        this.testoRepo = testoRepo;
        this.multiRepo = multiRepo;
        this.segnalazioneRepo = segnalazioneRepo;
        this.reportFactory = reportFactory;
        this.utenteRepository = utenteRepository;
    }





    public List<Segnalazione> getSegnalazioni(){
        return segnalazioneRepo.findAll();
    }



    public Segnalazione aggiungiSegnalazione(SegnalazioniDTO segnalazioniDTO){
        Segnalazione segnalazione = reportFactory.createSegnalazione(segnalazioniDTO);
        return segnalazioneRepo.save(segnalazione);
    }


    // Da testare
    @Transactional
    public void eliminaSegnalazione(Long id) {
        Segnalazione segnalazione = segnalazioneRepo.findById(id).orElseThrow();
        if (segnalazione.getStatoSegnalazioni().equals(StatoSegnalazioni.ACCETTATO)) {
            Long contentId = segnalazione.getContentId();
            ContenutoTestuale contenuto =  testoRepo.findById(contentId).orElseThrow();
            testoRepo.delete(contenuto);
            segnalazioneRepo.deleteById(id);
        } else if (segnalazione.getStatoSegnalazioni().equals(StatoSegnalazioni.RIFIUTATO)) {
            segnalazioneRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }



    public void accettaSegnalazione(Long segnalazioneId){
        Segnalazione segnalazione = segnalazioneRepo.findById(segnalazioneId).orElseThrow();

        segnalazione.setStatoSegnalazioni(StatoSegnalazioni.ACCETTATO);
        segnalazioneRepo.save(segnalazione);
    }






    public Segnalazione getSegnalazione(Long id, Contenuto contenuto) {
        Segnalazione segnalazione = segnalazioneRepo.findById(id).orElseThrow();
        if(segnalazione.getContenuto().equals(contenuto)){
            return segnalazione;
        }
        return null;

    }



    public void rifiutaSegnalazione(Long segnalazioneId){

        Segnalazione segnalazione = segnalazioneRepo.findById(segnalazioneId).orElseThrow();

        segnalazione.setStatoSegnalazioni(StatoSegnalazioni.RIFIUTATO);
        segnalazioneRepo.save(segnalazione);

    }



}



