package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contenuto")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContenutoTestuale.class, name = "testo"),
        @JsonSubTypes.Type(value = ContenutoMultimediale.class, name = "media")
})
public abstract class Contenuto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private boolean pending;
    private ContenutiStati stati;
    private ContenutoTipo tipo;
    private String nome;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "puntoDiInteresse_id")
    @JsonBackReference
    private PuntoDiInteresse puntoDiInteresse;

    private LocalDate date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "comune_id")
    @JsonBackReference
    private Comune comune;

    @OneToMany(mappedBy = "contenuto", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Contenuto(String nome, ContenutiStati stati) {
        this.nome = nome;
        this.stati = stati;
    }
}
