package com.it.unicam.progetto_ids_2023.service;


import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoMultimedialeRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoTestualeRepository;
import com.it.unicam.progetto_ids_2023.repository.SegnalazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class SegnalazioniService {




    private ContenutoMultimedialeRepository multiRepo;

    private ContenutoTestualeRepository testoRepo;

    private ComuneRepository comuneRepo;

    private PuntoDiInteresse punto;


    private SegnalazioniRepository segnalazioneRepo;


    @Autowired
    public SegnalazioniService(ContenutoTestualeRepository testoRepo, ContenutoMultimedialeRepository multiRepo, SegnalazioniRepository segnalazioneRepo) {
        this.testoRepo = testoRepo;
        this.multiRepo = multiRepo;
        this.segnalazioneRepo = segnalazioneRepo;
    }

    public void popolaRepository(){
        ContenutoTestuale contenutoTestuale = new ContenutoTestuale("Camerino", true);
        testoRepo.save(contenutoTestuale);
        Segnalazione segnalazione = new Segnalazione(contenutoTestuale, "segnalato");
        segnalazioneRepo.save(segnalazione);

    }

    public List<Segnalazione> getSegnalazioni(){
        return segnalazioneRepo.findAll();
    }



    public Segnalazione aggiungiSegnalazione(String testo, Contenuto contenuto){
        Segnalazione segnalazione = new Segnalazione(contenuto, testo);

        return segnalazioneRepo.save(segnalazione);
    }


    // Da testare
    public void eliminaSegnalazione(Long id){
        Segnalazione segnalazione = segnalazioneRepo.findById(id).orElseThrow();

        segnalazioneRepo.delete(segnalazione);
    }




    //Da testare


    public void accettaContenuto(Long contenutoId){
        ContenutoTestuale contenuto = testoRepo.findById(contenutoId).orElseThrow();
        List<Segnalazione> segnalazioni = segnalazioneRepo.findByContenuto(contenuto);
        Optional<Segnalazione> optionalSegnalazione = segnalazioni.stream().findAny();

        if (optionalSegnalazione.isPresent()) {
            Segnalazione segnalazione = optionalSegnalazione.get();
            segnalazioneRepo.deleteById(segnalazione.getId());
            contenuto.setPending(false);
            testoRepo.save(contenuto);
        } else {
            throw new NoSuchElementException("Segnalazione not found for this Contenuto");
        }
    }


    //Da testare

    public Segnalazione getSegnalazione(Long id, Contenuto contenuto) {
        Segnalazione segnalazione = segnalazioneRepo.findById(id).orElseThrow();
        if(segnalazione.getContenuto().equals(contenuto)){
            return segnalazione;
        }
        return null;

    }



    //Da sistemare null exception e aggiungere i contenutiMultimediali
    public void rifiutaContenuto(Long contenutoTestoId/*, Long contenutoMultiId*/){

        /* ContenutoMultimediale contenutoMulti = multiRepo.findById(contenutoMultiId).orElseThrow(); */
        ContenutoTestuale contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        List<Segnalazione> segnalazioni = segnalazioneRepo.findByContenuto(contenutoTestuale);
        Optional<Segnalazione> optionalSegnalazione = segnalazioni.stream().findAny();

        if (optionalSegnalazione.isPresent()) {
            Segnalazione segnalazione = optionalSegnalazione.get();
            /*   multiRepo.delete(contenutoMulti);*/
            testoRepo.delete(contenutoTestuale);

            segnalazioneRepo.deleteById(segnalazione.getId());
        } else {
            throw new NoSuchElementException("Segnalazione not found for this Contenuto");
        }

    }

}
