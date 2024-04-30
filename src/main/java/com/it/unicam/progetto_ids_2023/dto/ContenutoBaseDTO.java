package com.it.unicam.progetto_ids_2023.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;

public record ContenutoBaseDTO(



    String testo,
    boolean pending,
    ContenutiStati stati

    /*
    String file,
    ContenutoTipo tipo
     */


) {

}
