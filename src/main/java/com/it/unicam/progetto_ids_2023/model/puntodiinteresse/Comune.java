package main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data

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

    @OneToMany(mappedBy = "comune", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference


    private List<Contenuto> contenuto;



    @OneToMany(mappedBy = "comune", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference



    private List<PuntoDiInteresse> puntoDiInteresse;



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

    public Comune(String nome, String descrizione, Coordinate coordinate) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.coordinate = coordinate;

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

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
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
