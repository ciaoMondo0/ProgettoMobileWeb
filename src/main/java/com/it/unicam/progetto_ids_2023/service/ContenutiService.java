package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.contenuto.*;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.utente.Contributor;
import com.it.unicam.progetto_ids_2023.model.utente.ContributorAutorizzato;
import com.it.unicam.progetto_ids_2023.model.utente.Curatore;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.ContenutoMultimedialeRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoTestualeRepository;
import org.springframework.stereotype.Service;


@Service

public class ContenutiService {

    private ContenutoMultimedialeRepository multiRepo;
    private ContenutoTestualeRepository testoRepo;

    public void addContenuto(Utente utente, ContenutoMultimediale multimediale, ContenutoTestuale testuale, PuntoDiInteresse puntoDiInteresse, Comune comune){

        if(utente instanceof ContributorAutorizzato || utente instanceof Curatore) {
       /*  // multimediale.setUtente(utente);
            multimediale.setComune(comune);
            multimediale.setPuntoDiInteresse(puntoDiInteresse);
          //  testuale.setUtente(utente);
            testuale.setComune(comune);
            testuale.setPuntoDiInteresse(puntoDiInteresse);


            multimediale.setPending(false);
            testuale.setPending(false);
            multiRepo.save(multimediale);
            testoRepo.save(testuale);*/
        } else if (utente instanceof Contributor){
      //     multimediale.setUtente(utente);
  /*          multimediale.setComune(comune);
            multimediale.setPuntoDiInteresse(puntoDiInteresse);
        //    testuale.setUtente(utente);
            testuale.setComune(comune);
            testuale.setPuntoDiInteresse(puntoDiInteresse);

            multimediale.setPending(true);
            testuale.setPending(true);
            multiRepo.save(multimediale);
            testoRepo.save(testuale); */

        } else {
            throw new IllegalArgumentException();
        }



    }

    public void deleteContenutoTestuale(Long multiMediaid, Long testoId){
        ContenutoMultimediale multimedia = multiRepo.findById(multiMediaid).orElseThrow();
        ContenutoTestuale testuale = testoRepo.findById(testoId).orElseThrow();
        if(testuale.getStati().equals(ContenutiStati.RIFIUTATO)) {

            testoRepo.delete(testuale);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteContenutoMultimediale(Long contenutoMediaId){
       /* ContenutoMultimediale multimedia = multiRepo.findById(multiMediaid).orElseThrow();
        if(testuale.getStati().equals(ContenutiStati.RIFIUTATO)) {

            testoRepo.delete(testuale);
        } else {
            throw new IllegalArgumentException();
        } */


    }




    public void rifiutaContenutoTestuale(Long contenutoTestoId){

        ContenutoTestuale contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        if(contenutoTestuale.isPending()){
            contenutoTestuale.setStato(ContenutiStati.RIFIUTATO);
            testoRepo.save(contenutoTestuale);
        }
        else {
            throw new IllegalArgumentException();
        }


    }

    public void rifiutaContenutoMultimediale(Long contenutoTestoId){

        ContenutoTestuale contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        if(contenutoTestuale.isPending()){
            contenutoTestuale.setStato(ContenutiStati.RIFIUTATO);
            testoRepo.save(contenutoTestuale);
        }
        else {
            throw new IllegalArgumentException();
        }


    }



}








