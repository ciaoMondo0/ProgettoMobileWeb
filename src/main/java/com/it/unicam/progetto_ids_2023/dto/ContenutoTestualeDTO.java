package com.it.unicam.progetto_ids_2023.dto;

import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;

public record ContenutoTestualeDTO(



    String testo,
    boolean pending,
    ContenutiStati stati

    /*
    String file,
    ContenutoTipo tipo
     */


) {

}
