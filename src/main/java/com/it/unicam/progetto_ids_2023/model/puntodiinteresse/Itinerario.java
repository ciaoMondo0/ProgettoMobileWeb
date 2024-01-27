package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class Itinerario extends PuntoDiInteresse {
    private List<PuntoFisico> puntiFisici;

    public Itinerario(String nome, String descrizione) {
        super(nome,descrizione);
        this.puntiFisici = new ArrayList<>();
    }

    public List<PuntoFisico> getPuntiFisici() {
        return puntiFisici;
    }

    public void setPuntiFisici(List<PuntoFisico> puntiFisici) {
        this.puntiFisici = puntiFisici;
    }

    public List<Contenuto> getContenuti(){
        List<Contenuto> contenuti = new ArrayList<>();
        for(PuntoDiInteresse puntoDiInteresse : getPuntiFisici())
            contenuti.addAll(puntoDiInteresse.getContenuti());
        return contenuti;
    }
}
