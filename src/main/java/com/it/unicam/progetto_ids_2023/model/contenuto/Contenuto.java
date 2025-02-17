package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "contenuto")
@Data

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContenutoTestuale.class, name = "testo"),
        @JsonSubTypes.Type(value = ContenutoMultimediale.class, name = "media")


})
public abstract class Contenuto  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    //Appena aggiunto
    @Column(name = "id", updatable = false, nullable = false)

    private Long id;
    /* il contenuto è in stato di pending (deve essere validato) */
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
    @JoinColumn(name = "comune_id"/*, nullable = false*/)
    @JsonBackReference

    private Comune comune;

    @OneToMany(mappedBy = "contenuto", cascade = CascadeType.ALL)
    private List<Comment> comments;





    public Contenuto(){}

    public Contenuto(String nome,  ContenutiStati stati) {
       this.nome = nome; this.stati = stati;
    }


    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void setStato(ContenutiStati stati){
        this.stati = stati;
    }

    public ContenutiStati getStati(){
        return stati;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public ContenutoTipo getTipo(){
        return tipo;
    }

    public void setTipo(ContenutoTipo tipo){
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    //public abstract String getContenuto();
}
