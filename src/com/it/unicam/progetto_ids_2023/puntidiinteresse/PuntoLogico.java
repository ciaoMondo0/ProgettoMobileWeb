package com.it.unicam.progetto_ids_2023.puntidiinteresse;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class PuntoLogico implements PuntoDiInteresse{
    private String nome;
    private String descrizione;
    private List<Contenuto> contenuti;

    public PuntoLogico(String nome, String descrizione, List<Contenuto> contenuti) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.contenuti = new ArrayList<>();
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }
}
