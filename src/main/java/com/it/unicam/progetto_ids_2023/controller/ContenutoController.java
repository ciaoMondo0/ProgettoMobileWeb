package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.observer.Observer;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Itinerario;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.utente.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContenutoController {

    @RequestMapping(value = "/")
    public Contenuto getContenuto(){
        return new ContenutoMultimediale("ciao.jpg",true);
    }





    private Utente utente;
    private Observer curatore = new Curatore();
    private Observer animatore = new Animatore();
    private Observer gestore = new GestorePiattaforma();

    public ContenutoController(Utente utente){
        this.utente = utente;
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

    public boolean addContenutoContest(Contest contestContribuzione, Contenuto contenuto){
        return false;
    }

    public boolean segnalaContenuto(Contenuto contenuto){
        return false;
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

