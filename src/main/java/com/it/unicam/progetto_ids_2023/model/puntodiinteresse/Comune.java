package main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;

import java.util.List;

@Entity
@Table
@Data
public class Comune {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String descrizione;

    private Coordinate coordinate;

    @OneToMany(mappedBy = "comune", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Contenuto> contenuto;

    @OneToMany(mappedBy = "comune", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PuntoDiInteresse> puntoDiInteresse;

    public Comune() {
    }

    public Comune(String nome, String descrizione, Coordinate coordinate) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.coordinate = coordinate;
    }
}
