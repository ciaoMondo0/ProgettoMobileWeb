package com.it.unicam.progetto_ids_2023.dto;

import java.util.List;

public record ContestDTO(
         Long id,
         String tematica,
         List<String> contenuti,
         boolean pubblico,
         List<String> listaInvitati,
         boolean closed

) {
}
