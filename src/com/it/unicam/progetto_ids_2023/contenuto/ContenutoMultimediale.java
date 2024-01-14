package com.it.unicam.progetto_ids_2023.contenuto;

public class ContenutoMultimediale implements Contenuto{
    private String filePath;

    public ContenutoMultimediale(String filePath){
        this.filePath = filePath;
    }

    @Override
    public String getContenuto() {
        return filePath;
    }
}
