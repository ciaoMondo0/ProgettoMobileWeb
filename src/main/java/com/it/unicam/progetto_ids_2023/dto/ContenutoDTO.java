package com.it.unicam.progetto_ids_2023.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;

public record ContenutoDTO(
      Long id,

     // Comune comune,

     // PuntoDiInteresse puntoDiInteresse,


      Utente utente,
      Comune comune,
      boolean pending,
      ContenutiStati stati,

      String testo






) {
}
