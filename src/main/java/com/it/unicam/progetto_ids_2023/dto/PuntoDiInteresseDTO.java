package main.java.com.it.unicam.progetto_ids_2023.dto;

import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Coordinate;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresseCategorie;

public record PuntoDiInteresseDTO(String nome,
                                  String descrizione,
                                  PuntoDiInteresseCategorie categorie,
                                  Long comuneId,
                                  Coordinate coordinate) {
}
