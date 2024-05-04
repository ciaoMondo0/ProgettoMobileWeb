package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Itinerario /*extends PuntoDiInteresse*/ {


/*
@ElementCollection(targetClass = PuntoFisico.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "punti_fisici", joinColumns = @JoinColumn(name = "punto_fisico_id"))
//    //@Column(name = "contenuto", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<PuntoFisico> puntiFisici;
 */

    @Id
    @GeneratedValue
    private Long id;


    @OneToMany
    private List<PuntoDiInteresse> puntoDiInteresse;

    private String nome;



    private String descrizione;

    public Itinerario(){}

    public Itinerario(String nome, String descrizione, List<PuntoDiInteresse> puntoDiInteresse) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.puntoDiInteresse = puntoDiInteresse;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<PuntoDiInteresse> getPuntoDiInteresse() {
        return puntoDiInteresse;
    }

    public void setPuntoDiInteresse(List<PuntoDiInteresse> puntoDiInteresse) {
        this.puntoDiInteresse = puntoDiInteresse;
    }

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


//    public List<Contenuto> getContenuti(){
//        List<Contenuto> contenuti = new ArrayList<>();
//        for(PuntoDiInteresse puntoDiInteresse : getPuntiFisici())
//            contenuti.addAll(puntoDiInteresse.getContenuti());
//        return contenuti;
//    }
}
