package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;
import com.it.unicam.progetto_ids_2023.model.utente.Contributor;
import com.it.unicam.progetto_ids_2023.model.utente.ContributorAutorizzato;
import com.it.unicam.progetto_ids_2023.model.utente.Curatore;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.ContenutoMultimedialeRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoTestualeRepository;

public class ContenutiService {

    private ContenutoMultimedialeRepository multiRepo;
    private ContenutoTestualeRepository testoRepo;

    public void addContenuto(Utente utente, ContenutoMultimediale multimediale, ContenutoTestuale testuale){

        if(utente instanceof ContributorAutorizzato || utente instanceof Curatore) {
            multimediale.setPending(false);
            testuale.setPending(false);
            multiRepo.save(multimediale);
            testoRepo.save(testuale);
        } else if (utente instanceof Contributor){
            multimediale.setPending(true);
            testuale.setPending(true);
            multiRepo.save(multimediale);
            testoRepo.save(testuale);

        } else {
            throw new IllegalArgumentException();
        }

    }

    public void deleteContenuto(Long multiMediaid, Long testoId){
        ContenutoMultimediale multimedia = multiRepo.findById(multiMediaid).orElseThrow();
        ContenutoTestuale testuale = testoRepo.findById(testoId).orElseThrow();

        multiRepo.delete(multimedia);
        testoRepo.delete(testuale);
    }

}
