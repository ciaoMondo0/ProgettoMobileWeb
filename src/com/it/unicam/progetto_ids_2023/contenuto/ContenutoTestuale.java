package com.it.unicam.progetto_ids_2023.contenuto;

public class ContenutoTestuale extends Contenuto {
    private String testo;

    public ContenutoTestuale(String testo, boolean pending){
        super(pending);
        this.testo = testo;
    }

    @Override
    public String getContenuto() {
        return testo;
    }
}
