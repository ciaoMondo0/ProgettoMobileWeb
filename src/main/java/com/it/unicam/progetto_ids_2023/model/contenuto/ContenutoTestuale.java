package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class ContenutoTestuale extends Contenuto {
    @JsonProperty("testo")
    private String testo;

    public ContenutoTestuale(){}

    public ContenutoTestuale(String testo, boolean pending) {
        super(pending);
        this.testo = testo;
    }

//    @Override
//    public String getContenuto() {
//        return testo;
//    }
}
