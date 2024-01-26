package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
import com.it.unicam.progetto_ids_2023.model.observer.Observer;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Itinerario;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.utente.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContenutoManager {

    @RequestMapping(value = "/")
    public Contenuto getContenuto(){
        return new ContenutoMultimediale("ciao.jpg",true);
    }





    private Utente utente;
    private Observer curatore = new Curatore();
    private Observer animatore = new Animatore();
    private Observer gestore = new GestorePiattaforma();

    private List<Contenuto> contenuti;

    public ContenutoManager(/* Utente */){
        /*Utente*/
        contenuti = new ArrayList<Contenuto>();

    }


    // Da testare
    public void addContenuto(Contenuto contenuto){
        this.contenuti.add(contenuto);
    }

    public boolean addContenutoPOI(PuntoDiInteresse puntoDiInteresse, Contenuto contenuto){

        /*In teoria se il controllo del ruolo viene fatto
         *al momento del login non deve venire effettuato qui dentro */

        boolean status;

        if((puntoDiInteresse instanceof Itinerario) &&
                (utente.getRuolo().equals(Ruolo.TURISTA_AUTENTICATO))){
            puntoDiInteresse.getContenuti().add(contenuto);
            status = true;
        }
        else if(utente.getRuolo().equals(Ruolo.CONTRIBUTOR)){
            contenuto.setPending(true);
            puntoDiInteresse.getContenuti().add(contenuto);
            notificaCuratore();
            status = true;
        }
        else if(utente.getRuolo().equals(Ruolo.CONTRIBUTOR_AUTORIZZATO)){
            puntoDiInteresse.getContenuti().add(contenuto);
            status = true;
        }
        else
            status = false;

        return status;
    }

    public boolean addContenutoContest(ContestManager contestContribuzione, Contenuto contenuto) {
        if(contestContribuzione == null || contenuto == null) {
            throw new IllegalArgumentException("Il ContestController e il Contenuto non possono essere null");
        }
        contestContribuzione.addContenuto(contenuto);
        return true;
    }


    // Da testare
    public void deleteContenuto(Contenuto contenuto){
        if(contenuti.contains(contenuto)){
            contenuti.remove(contenuto);
        } else {
            throw new IllegalArgumentException("Il contenuto non è presente");
        }
    }

    public List<Contenuto> getContenuti(){
        return contenuti;
    }


// Da testare
    public boolean segnalaContenuto(SegnalazioniManager segnalazioniManager, Contenuto contenuto) {
        if(contenuto != null) {
            segnalazioniManager.addSegnalazione("Segnalazione per contenuto non appropriato", contenuto);
            return true;
        } else {
            throw new IllegalArgumentException("Il contenuto non può essere null");
        }
    }







    //NOTIFICHE
    public void notificaCuratore(){
        curatore.update();
    }

    public void notificaAnimatore(){
        animatore.update();
    }

    public void notificaGestore(){
        gestore.update();
    }
}
