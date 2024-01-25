package com.it.unicam.progetto_ids_2023.utenti;

public class ContributorAutorizzato extends Utente{

    private final Ruolo ruolo = Ruolo.CONTRIBUTOR_AUTORIZZATO;

    public ContributorAutorizzato(String nome, String email){
        super(nome,email);
    }

    @Override
    public Ruolo getRuolo() {
        return ruolo;
    }
}
