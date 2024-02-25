package com.it.unicam.progetto_ids_2023.dto;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.StatoSegnalazioni;

public record SegnalazioniDTO(
        Contenuto contenuto,
        String testoSegnalazione,

        StatoSegnalazioni statoSegnalazioni
) {
}
