package com.it.unicam.progetto_ids_2023.model.contenuto;

import java.util.ArrayList;
import java.util.List;

public class Contest{
    /*Il contest contiene una tematica, una lista di contenuti, un valore booleano che indica se il contest
     * è pubblico (aperto a tutti) oppure se è chiuso. Se il contest è chiuso, viene inizializzata la lista
     * degli invitati, che conterrà le email dei partecipanti */

    private String tematica;
    private List<Contenuto> contenuti;
    private boolean pubblico;
    private List<String> listaInvitati;

    public Contest(String tematica, boolean pubblico) {
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
}
