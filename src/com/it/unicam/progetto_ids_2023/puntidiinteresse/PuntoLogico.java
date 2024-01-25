package com.it.unicam.progetto_ids_2023.puntidiinteresse;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.util.ArrayList;
import java.util.List;

public class PuntoLogico extends PuntoDiInteresse {

    public PuntoLogico(int id,String nome, String descrizione) {
        super(id,nome,descrizione);
    }

    @Override
    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }
}
