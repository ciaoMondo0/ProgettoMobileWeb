package com.it.unicam.progetto_ids_2023.utenti;

import com.it.unicam.progetto_ids_2023.contest.ContestObserver;

public class Animatore extends Utente implements ContestObserver {

    private final Ruolo ruolo = Ruolo.ANIMATORE;
    public Animatore(String nome) {
        super(nome);
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    @Override
    public void update() {
        System.out.println("E' presente del nuovo contenuto da validare");
    }
}
