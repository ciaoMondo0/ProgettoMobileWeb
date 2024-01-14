package com.it.unicam.progetto_ids_2023.contest;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class ContestContribuzione {
    private String tematica;
    private List<Contenuto> contenuti;
    private boolean pubblico;
    private List<String> listaInvitati;

    private ContestObserver animatore;

    public ContestContribuzione(String tematica, boolean pubblico) {
        this.tematica = tematica;
        this.contenuti = new ArrayList<>();
        this.pubblico = pubblico;

        //se il contest non è aperto a tutti inizializza la lista di invitati (conterrà le email degli invitati)
        if(!pubblico) this.listaInvitati = new ArrayList<>();
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }

    public boolean isPubblico() {
        return pubblico;
    }

    public void setPubblico(boolean pubblico) {
        this.pubblico = pubblico;
    }

    public List<String> getListaInvitati() {
        return listaInvitati;
    }

    public void setListaInvitati(List<String> listaInvitati) {
        this.listaInvitati = listaInvitati;
    }

    public void notificaAnimatore(){
        animatore.update();
        //TODO: per notificare l'animatore,
        // bisogna mettere questo metodo all'interno del metodo
        // per caricare contenuto nel contest
    }
}
