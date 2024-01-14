package com.it.unicam.progetto_ids_2023.utenti;

public class Utente {
    protected String nome;

    public Utente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}