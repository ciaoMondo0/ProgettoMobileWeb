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
    private StatoSegnalazioni statoSegnalazioni;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    public Segnalazione(Contenuto contenuto, String testoSegnalazione, StatoSegnalazioni statoSegnalazioni){
        this.contenuto = contenuto;
        this.testoSegnalazione = testoSegnalazione;
        this.statoSegnalazioni = statoSegnalazioni;
    }

    public Segnalazione(Long id, Contenuto contenuto, String testoSegnalazione, StatoSegnalazioni statoSegnalazioni) {
        this.id = id;
        this.contenuto = contenuto;
        this.testoSegnalazione = testoSegnalazione;
        this.statoSegnalazioni = statoSegnalazioni;

    }

    public Segnalazione() {

    }

    public Contenuto getContenuto() {
        return contenuto;
    }

    public void setContenuto(Contenuto contenuto) {
        this.contenuto = contenuto;
    }

    public void setStatoSegnalazioni(StatoSegnalazioni stati){
        this.statoSegnalazioni = stati;
    }

    public StatoSegnalazioni getStatoSegnalazioni(){
        return this.statoSegnalazioni;
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

    public Long getContentId() {
        return this.contenuto.getId();
    }
}
