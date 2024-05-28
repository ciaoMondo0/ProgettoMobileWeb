package main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Coordinate {

    private float latitudine;
    private float longitudine;
}
