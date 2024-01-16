package com.it.unicam.progetto_ids_2023.puntidiinteresse;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.util.List;

public class Comune implements PuntoDiInteresse{
    private String nome;
    private List<Contenuto> contenuti;
    private List<PuntoDiInteresse> puntiDiInteresse;

    public Comune(List<Contenuto> contenuti, List<PuntoDiInteresse> puntiDiInteresse) {
        this.contenuti = contenuti;
        this.puntiDiInteresse = puntiDiInteresse;
    }

    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }

    public List<PuntoDiInteresse> getPuntiDiInteresse() {
        return puntiDiInteresse;
    }

    public void setPuntiDiInteresse(List<PuntoDiInteresse> puntiDiInteresse) {
        this.puntiDiInteresse = puntiDiInteresse;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
