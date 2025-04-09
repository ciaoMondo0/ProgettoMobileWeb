package main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
@Data
public class PuntoDiInteresse {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    private String nome;
    private String descrizione;

    private PuntoDiInteresseCategorie categorie;

    @ManyToOne
    @JoinColumn(name = "comune_id")
    @JsonBackReference
    private Comune comune;

    private Coordinate coordinate;

    public PuntoDiInteresse() {
    }

    public PuntoDiInteresse(String nome, String descrizione, PuntoDiInteresseCategorie categorie, Coordinate coordinate) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.categorie = categorie;
        this.coordinate = coordinate;
    }
}
