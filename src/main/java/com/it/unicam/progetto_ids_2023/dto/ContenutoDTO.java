package main.java.com.it.unicam.progetto_ids_2023.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTipo;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;

public record ContenutoDTO(




      String nomeContenuto,
      String nome,

      ContenutoTipo tipo,

      String testo,

      String file,
      Long utenteId // Aggiungi questo parametro






) {
}
