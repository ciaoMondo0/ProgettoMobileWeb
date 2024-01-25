package com.it.unicam.progetto_ids_2023.utenti;

import com.it.unicam.progetto_ids_2023.Observer;
import com.it.unicam.progetto_ids_2023.contenuto.Segnalazione;

import java.util.ArrayList;
import java.util.List;

public class Curatore extends Utente implements Observer {
    private final Ruolo ruolo = Ruolo.CURATORE;
    private List<Segnalazione> segnalazioni;

    public Curatore(){}
    public Curatore(String nome, String email){
        super(nome,email);
        this.segnalazioni = new ArrayList<>();
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public List<Segnalazione> getSegnalazioni() {
        return segnalazioni;
    }

    public void setSegnalazioni(List<Segnalazione> segnalazioni) {
        this.segnalazioni = segnalazioni;
    }

    @Override
    public void update() {
        System.out.println("E' presente del nuovo contenuto da validare");
    }
}
