package com.it.unicam.progetto_ids_2023.puntidiinteresse;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class Itinerario implements PuntoDiInteresse{
    private String nome;
    private List<PuntoFisico> puntiFisici;

    public Itinerario(String nome, List<PuntoFisico> puntiFisici) {
        this.nome = nome;
        this.puntiFisici = new ArrayList<>();
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PuntoFisico> getPuntiFisici() {
        return puntiFisici;
    }

    public void setPuntiFisici(List<PuntoFisico> puntiFisici) {
        this.puntiFisici = puntiFisici;
    }

    @Override
    public List<Contenuto> getContenuti() {
        List<Contenuto> contenutiItinerario = new ArrayList<>();
        for (PuntoFisico punto : puntiFisici) {
            contenutiItinerario.addAll(punto.getContenuti());
        }
        return contenutiItinerario;
    }
}
