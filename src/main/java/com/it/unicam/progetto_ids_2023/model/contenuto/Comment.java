package com.it.unicam.progetto_ids_2023.model.contenuto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import jakarta.persistence.*;

@Entity
public class Comment {
    public Comment(Long id, Contenuto contenuto, Utente utente, String testo) {
        this.id = id;
        this.contenuto = contenuto;
        this.utente = utente;
        this.testo = testo;
    }

    public Comment(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnore

    @ManyToOne
    private Contenuto contenuto;

    @ManyToOne
    private Utente utente;

    @Column(columnDefinition = "TEXT")
    private String testo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contenuto getContenuto() {
        return contenuto;
    }

    public void setContenuto(Contenuto contenuto) {
        this.contenuto = contenuto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }


}
