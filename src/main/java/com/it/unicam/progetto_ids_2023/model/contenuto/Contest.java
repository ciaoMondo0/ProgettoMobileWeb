package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.it.unicam.progetto_ids_2023.model.utente.*;

import java.util.ArrayList;
import java.util.List;

public class Contest {

    private String data;
    private String obiettivo;


    private List<Contributor> partecipanti;

    private List<Contenuto> contenuti;
    private boolean aperto;
    private boolean pubblico;


    public Contest(String data, String obiettivo, boolean pubblico, List<Contributor> partecipanti, List<Contenuto> contenuti) {
        this.data = data;
        this.obiettivo = obiettivo;
        this.pubblico = pubblico;
        this.contenuti = contenuti;
        this.aperto = true;
        this.partecipanti = new ArrayList<>();

    }

    public Contest() {

    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObiettivo() {
        return obiettivo;
    }

    public void setObiettivo(String obiettivo) {
        this.obiettivo = obiettivo;
    }



    public List<Contributor> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(List<Contributor> partecipanti) {
        this.partecipanti = partecipanti;
    }

    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }

    public boolean isAperto() {
        return aperto;
    }

    public void setAperto(boolean aperto) {
        this.aperto = aperto;
    }

    public boolean isPubblico(){
        return pubblico;
    }

    public void setPubblic(boolean pubblico){
        this.pubblico = pubblico;
    }




}









