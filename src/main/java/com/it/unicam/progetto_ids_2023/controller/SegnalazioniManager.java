package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;

import java.util.ArrayList;
import java.util.List;

public class SegnalazioniManager {

    private List<Segnalazione> segnalazioni;
    private List<Contenuto> contenuti;

    ContenutoManager contenutoManager;

    public SegnalazioniManager(){
        this.segnalazioni = new ArrayList<Segnalazione>();
        this.contenuti = new ArrayList<Contenuto>();
        contenutoManager = new ContenutoManager();
    }


    public void addSegnalazione(String testo, Contenuto contenuto){
        Segnalazione segnalazione = new Segnalazione(contenuto, testo);
        segnalazioni.add(segnalazione);
        contenuti.add(contenuto);
    }

    public void approvaContenuto(Contenuto contenuto){
        Segnalazione segnalazione = getSegnalazioni(contenuto);
        if(segnalazione != null){
            contenuto.setPending(false);
            segnalazioni.remove(segnalazione);
        } else {
            throw new IllegalArgumentException("Nessun contenuto da approvare");
        }
    }


// Da testare
    public void rifiutaContenuto(Contenuto contenuto){
        Segnalazione segnalazione = getSegnalazioni(contenuto);
        if(segnalazione != null && contenutoManager.getContenuti().contains(contenuto)){
            contenuto.setPending(false);
            contenutoManager.deleteContenuto(contenuto);
            segnalazioni.remove(segnalazione);

        } else {
            throw new IllegalArgumentException("Il contenuto non è presente");
        }
    }

    private Segnalazione getSegnalazioni(Contenuto contenuto) {
        for(Segnalazione segnalazione : segnalazioni) {
            if(segnalazione.getContenuto().equals(contenuto)) {
                return segnalazione;
            }
        }
        return null;
    }




}
