package com.it.unicam.progetto_ids_2023.contenuto;

public class Segnalazione {
    /*La segnalazione contiene il contenuto da segnalare ed un testo scritto dall'utente*/

    private Contenuto contenuto;
    private String testoSegnalazione;

    public Segnalazione(Contenuto contenuto, String testoSegnalazione){
        this.contenuto = contenuto;
        this.testoSegnalazione = testoSegnalazione;
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
}
