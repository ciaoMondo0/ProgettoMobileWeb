package com.it.unicam.progetto_ids_2023.dto;

import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;

public record UtenteDTO(
     //   Long id,
        Ruolo ruolo,
        String username,
        String email,
        String password


) {

}
