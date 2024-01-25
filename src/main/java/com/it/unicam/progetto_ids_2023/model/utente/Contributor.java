package com.it.unicam.progetto_ids_2023.model.utente;

public class Contributor extends Utente{
    private final Ruolo ruolo = Ruolo.CONTRIBUTOR;

    public Contributor(String nome, String email) {
        super(nome, email);
    }

    @Override
    public Ruolo getRuolo() {
        return ruolo;
    }
}
