package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Evento extends PuntoDiInteresse{


    /*
       @ElementCollection(targetClass = PuntoDiInteresse.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "punti_di_interesse", joinColumns = @JoinColumn(name = "punto_di_interesse_id"))
//    //@Column(name = "contenuto", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JdbcTypeCode(SqlTypes.JSON)
    private Set<PuntoDiInteresse> puntiDiInteresse;
     */
    private LocalDateTime inizio;
    private LocalDateTime fine;

    public Evento(){}

    public Evento(String nome, String descrizione, LocalDateTime inizio, LocalDateTime fine) {
        super(nome,descrizione);
        this.inizio = inizio;
        this.fine = fine;

    }


    public LocalDateTime getInizio() {
        return inizio;
    }

    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public LocalDateTime getFine() {
        return fine;
    }

    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }
  /*
   public void addPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse){
        puntiDiInteresse.add(puntoDiInteresse);
    }
   */

}
