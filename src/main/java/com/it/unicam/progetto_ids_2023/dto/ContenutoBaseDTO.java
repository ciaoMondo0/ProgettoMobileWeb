package com.it.unicam.progetto_ids_2023.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;

public record ContenutoBaseDTO(

    //    Long id,
     //   boolean pending,
      //  @JsonProperty("testo") String testo,

      //  ContenutiStati stato

       //    Long id,

        // Comune comune,

        // PuntoDiInteresse puntoDiInteresse,

    //  Long id,
      // Utente utente,
    String boh,

    String testo,
    boolean pending,
    ContenutiStati stati


) {

}
