package com.it.unicam.progetto_ids_2023.model.utente;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;


//@Entity
//@Table (name = "utente")

public  class Utente {



   @Id
   @GeneratedValue
    private String nome;
    private String email;
    private Ruolo ruolo;


   /* @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contenuto_id")

    private Contenuto contenuto; */

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

    public  Ruolo getRuolo(){
        return this.ruolo;
    }
}