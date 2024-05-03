package com.it.unicam.progetto_ids_2023.service;


import com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.*;
import com.it.unicam.progetto_ids_2023.model.factory.ReportFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SegnalazioniService {


    private ReportFactory reportFactory;

    private ContenutoMultimedialeRepository multiRepo;

    private ContenutoBaseRepository testoRepo;

    private ComuneRepository comuneRepo;

    private PuntoDiInteresse punto;

    private PuntoFisicoRepository puntoFisicoRepository;


    private SegnalazioniRepository segnalazioneRepo;

    private UtenteRepository utenteRepository;


    @Autowired
    public SegnalazioniService(ContenutoBaseRepository testoRepo, ContenutoMultimedialeRepository multiRepo, SegnalazioniRepository segnalazioneRepo, ComuneRepository comuneRepo, ReportFactory reportFactory
            , UtenteRepository utenteRepository) {
        this.comuneRepo = comuneRepo;
        //   this.puntoFisicoRepository = puntoFisicoRepository;
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
        // segnalazione.set
        return segnalazioneRepo.save(segnalazione);
    }


    // Da testare
    @Transactional
    public void eliminaSegnalazione(Long id) {
        Segnalazione segnalazione = segnalazioneRepo.findById(id).orElseThrow();
        if (segnalazione.getStatoSegnalazioni().equals(StatoSegnalazioni.ACCETTATO)) {
            Long contentId = segnalazione.getContentId();
            ContenutoBase contenuto =  testoRepo.findById(contentId).orElseThrow();
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





    //Da testare

    public Segnalazione getSegnalazione(Long id, Contenuto contenuto) {
        Segnalazione segnalazione = segnalazioneRepo.findById(id).orElseThrow();
        if(segnalazione.getContenuto().equals(contenuto)){
            return segnalazione;
        }
        return null;

    }



    //aggiungere i contenutiMultimediali
    public void rifiutaSegnalazione(Long segnalazioneId){

        Segnalazione segnalazione = segnalazioneRepo.findById(segnalazioneId).orElseThrow();

        segnalazione.setStatoSegnalazioni(StatoSegnalazioni.RIFIUTATO);
        segnalazioneRepo.save(segnalazione);

    }

    /* ContenutoMultimediale contenutoMulti = multiRepo.findById(contenutoMultiId).orElseThrow(); */
     /*   ContenutoTestuale contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        List<Segnalazione> segnalazioni = segnalazioneRepo.findByContenuto(contenutoTestuale);
        Optional<Segnalazione> optionalSegnalazione = segnalazioni.stream().findAny();

        if (optionalSegnalazione.isPresent()) {
            Segnalazione segnalazione = optionalSegnalazione.get();
            /*   multiRepo.delete(contenutoMulti);*/
        /*    testoRepo.delete(contenutoTestuale);

            segnalazioneRepo.deleteById(segnalazione.getId());
        } else {
            throw new NoSuchElementException("Segnalazione not found for this Contenuto");
        } */


}



