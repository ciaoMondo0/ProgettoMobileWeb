package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Coordinate {

    private float longitudine;
    private float latitudine;
}
