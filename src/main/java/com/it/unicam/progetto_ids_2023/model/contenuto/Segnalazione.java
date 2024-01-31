package com.it.unicam.progetto_ids_2023.model.contenuto;

import jakarta.persistence.*;

@Entity
@Table
public class Segnalazione {
    /*La segnalazione contiene il contenuto da segnalare ed un testo scritto dall'utente*/

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contenuto_id")
    private Contenuto contenuto;
    private String testoSegnalazione;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    public Segnalazione(Contenuto contenuto, String testoSegnalazione){
        this.contenuto = contenuto;
        this.testoSegnalazione = testoSegnalazione;
    }

    public Segnalazione(Long id, Contenuto contenuto, String testoSegnalazione) {
        this.id = id;
        this.contenuto = contenuto;
        this.testoSegnalazione = testoSegnalazione;

    }

    public Segnalazione() {

    }

    public Contenuto getContenuto() {
        return contenuto;
    }

    public void setContenuto(Contenuto contenuto) {
        this.contenuto = contenuto;
    }

    public String getTestoSegnalazione() {
        return testoSegnalazione;
    }

    public void setTestoSegnalazione(String testoSegnalazione) {
        this.testoSegnalazione = testoSegnalazione;
    }

    public Long getId() {
        return id;
    }
}
