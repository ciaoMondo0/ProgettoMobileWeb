package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoDiInteresse {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String descrizione;

    @ElementCollection(targetClass = Contenuto.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "contenuti", joinColumns = @JoinColumn(name = "punto_di_interesse_id"))
//    //@Column(name = "contenuto", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
//    @JdbcTypeCode(SqlTypes.JSON)
    protected List<Contenuto> contenuti;

    public PuntoDiInteresse(){}

    public PuntoDiInteresse(String nome, String descrizione){
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Contenuto> getContenuti(){
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }

    public void addContenuto(Contenuto contenuto){
        getContenuti().add(contenuto);
    }
}

