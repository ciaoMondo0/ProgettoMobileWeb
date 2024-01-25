package com.it.unicam.progetto_ids_2023.utenti;

public class TuristaAutenticato extends Utente{
    private final Ruolo ruolo = Ruolo.TURISTA_AUTENTICATO;

    public TuristaAutenticato(String nome, String email){
        super(nome,email);
    }

    @Override
    public Ruolo getRuolo() {
        return ruolo;
    }
}
