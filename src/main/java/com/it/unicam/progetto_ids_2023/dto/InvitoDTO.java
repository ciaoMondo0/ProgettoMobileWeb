package com.it.unicam.progetto_ids_2023.dto;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;

import java.util.List;

public record InvitoDTO(
    String invito,
   List<Long> utentiId,
    Long contestId
           ){

}


