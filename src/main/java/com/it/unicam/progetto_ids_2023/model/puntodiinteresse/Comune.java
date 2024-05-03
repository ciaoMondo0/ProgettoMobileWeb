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
@Table

public class Comune {


    /*
      @ElementCollection(targetClass = PuntoDiInteresse.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "poi_comune", joinColumns = @JoinColumn(name = "comune_id"))
//    //@Column(name = "contenuto", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<PuntoDiInteresse> puntiDiInteresse;
     */



    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descrizione;

    private Coordinate coordinate;






    public Comune(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Comune(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;

        /*
         this.puntiDiInteresse = new ArrayList<>();
        this.contenuti = new ArrayList<>();
         */

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /*
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
     */








}
