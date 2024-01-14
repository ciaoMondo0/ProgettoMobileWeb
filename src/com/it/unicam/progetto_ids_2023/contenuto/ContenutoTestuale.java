package com.it.unicam.progetto_ids_2023.contenuto;

public class ContenutoTestuale implements Contenuto{
    private String testo;

    public ContenutoTestuale(String testo){
        this.testo = testo;
    }

    @Override
    public String getContenuto() {
        return testo;
    }
}
