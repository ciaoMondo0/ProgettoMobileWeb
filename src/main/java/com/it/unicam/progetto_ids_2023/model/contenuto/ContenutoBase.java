package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import jakarta.persistence.Entity;

@Entity
public class ContenutoBase extends Contenuto {
    @JsonProperty("testo")
    private String testo;

    private String nome;
    private ContenutiStati stati;

    public ContenutoBase(){}

    public ContenutoBase(String testo, boolean pending, String nome) {
        super(nome, pending);
        this.testo = testo;
    }

    public ContenutoBase(String testo, boolean pending, ContenutiStati stati, String nome){
        super(nome, pending);
        this.testo = testo;
        this.stati = stati;
    }

    public ContenutoBase(Long id, Utente utente, String testo, boolean pending, ContenutiStati stati) {
    }


    public void setTesto(String testo){
        this.testo = testo;
    }

    public String getTesto(){
        return this.testo;
    }


//    @Override
//    public String getContenuto() {
//        return testo;
//    }
}
