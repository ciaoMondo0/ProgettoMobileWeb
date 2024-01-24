package com.it.unicam.progetto_ids_2023.puntidiinteresse;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class Itinerario extends PuntoDiInteresse {
    private List<PuntoFisico> puntiFisici;

    public Itinerario(int id, String nome, String descrizione) {
        super(id,nome,descrizione);
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
