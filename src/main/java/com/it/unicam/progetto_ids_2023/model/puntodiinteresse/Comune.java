package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class Comune extends PuntoDiInteresse{
    private List<PuntoDiInteresse> puntiDiInteresse;

    public Comune(int id, String nome, String descrizione) {
        super(id,nome,descrizione);
        this.puntiDiInteresse = new ArrayList<>();
    }

    public List<PuntoDiInteresse> getPuntiDiInteresse() {
        return puntiDiInteresse;
    }

    public void setPuntiDiInteresse(List<PuntoDiInteresse> puntiDiInteresse) {
        this.puntiDiInteresse = puntiDiInteresse;
    }

    @Override
    public List<Contenuto> getContenuti() {
        return contenuti;
    }
}
