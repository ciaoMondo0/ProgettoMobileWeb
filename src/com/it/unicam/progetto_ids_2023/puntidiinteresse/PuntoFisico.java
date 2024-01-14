package com.it.unicam.progetto_ids_2023.puntidiinteresse;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class PuntoFisico implements PuntoDiInteresse{
    String nome;
    double latitudine;
    double longitudine;
    private List<Contenuto> contenuti;

    public PuntoFisico(String nome, double latitudine, double longitudine, List<Contenuto> contenuti) {
        this.nome = nome;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.contenuti = new ArrayList<>();
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    @Override
    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }
}
