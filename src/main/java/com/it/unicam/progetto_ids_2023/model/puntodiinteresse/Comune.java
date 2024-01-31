package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Comune extends PuntoDiInteresse{

    @ElementCollection(targetClass = PuntoDiInteresse.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "poi_comune", joinColumns = @JoinColumn(name = "comune_id"))
//    //@Column(name = "contenuto", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<PuntoDiInteresse> puntiDiInteresse;

    public Comune(){}

    public Comune(String nome, String descrizione) {
        super(nome,descrizione);
        this.puntiDiInteresse = new ArrayList<>();
        this.contenuti = new ArrayList<>();
    }

    public List<PuntoDiInteresse> getPuntiDiInteresse() {
        return puntiDiInteresse;
    }

    public void setPuntiDiInteresse(List<PuntoDiInteresse> puntiDiInteresse) {
        this.puntiDiInteresse = puntiDiInteresse;
    }

    public void addPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse){
        puntiDiInteresse.add(puntoDiInteresse);
    }



    //Metodo aggiunto da Testare
    public void addContest(Contest contest) {
    }
}
