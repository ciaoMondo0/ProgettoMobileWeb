package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import jakarta.persistence.*;
import lombok.Data;



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
public class Contenuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    //Appena aggiunto
    @Column(name = "id", updatable = false, nullable = false)

    private Long id;
    /* il contenuto è in stato di pending (deve essere validato) */
    private boolean pending;
    private ContenutiStati stati;


  /* @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "autore_id")
    private Utente utente; */


  /* @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "puntoDiInteresse_id")
   private PuntoDiInteresse puntoDiInteresse;
   */


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "comune_id", nullable = false)
    private Comune comune;





    public Contenuto(){}

    public Contenuto(boolean pending) {
        this.pending = pending;
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

    //public abstract String getContenuto();
}
