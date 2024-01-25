package com.it.unicam.progetto_ids_2023.model.utente;

public class Richiesta {

    private Contributor contributor;
    private String testoRichiesta;

    public Richiesta(Contributor contributor,String testoRichiesta) {
        this.contributor = contributor;
        this.testoRichiesta = testoRichiesta;
    }

    public String getTestoRichiesta() {
        return testoRichiesta;
    }

    public void setTestoRichiesta(String testoRichiesta) {
        this.testoRichiesta = testoRichiesta;
    }

    public void getDatiUtente(){
        System.out.println(contributor.getNome()+contributor.getEmail());
    }
}
