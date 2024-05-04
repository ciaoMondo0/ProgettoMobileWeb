package com.it.unicam.progetto_ids_2023.dto;

import java.util.List;

public record ItinerarioDTO (
        String nome,
        String descrizione,

        List<Long> poiId


){

}