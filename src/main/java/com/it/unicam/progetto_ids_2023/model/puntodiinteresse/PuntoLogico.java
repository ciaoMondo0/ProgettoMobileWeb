package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;

import java.util.List;

public class PuntoLogico extends PuntoDiInteresse {

    public PuntoLogico(String nome, String descrizione) {
        super(nome,descrizione);
    }

    @Override
    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }
}
