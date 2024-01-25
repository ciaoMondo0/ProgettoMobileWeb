package com.it.unicam.progetto_ids_2023.model.contenuto;

public class ContenutoMultimediale extends Contenuto {
    /* stringa che contiene il percorso del file */
    private String filePath;

    public ContenutoMultimediale(String filePath, boolean pending){
        super(pending);
        this.filePath = filePath;
    }

    @Override
    public String getContenuto() {
        return filePath;
    }
}