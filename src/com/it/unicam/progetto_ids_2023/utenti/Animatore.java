package com.it.unicam.progetto_ids_2023.utenti;

import com.it.unicam.progetto_ids_2023.Observer;

public class Animatore extends Utente implements Observer {

    private final Ruolo ruolo = Ruolo.ANIMATORE;
    public Animatore(String nome, String email) {
        super(nome,email);
    }

    public Animatore(){}

    public Ruolo getRuolo() {
        return ruolo;
    }

    @Override
    public void update() {
        System.out.println("E' presente del nuovo contenuto da validare");
    }
}
