package com.it.unicam.progetto_ids_2023.model.utente;

public abstract class Utente {
    private String nome;
    private String email;
    private Ruolo ruolo;

    public Utente(){}

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract Ruolo getRuolo();
}