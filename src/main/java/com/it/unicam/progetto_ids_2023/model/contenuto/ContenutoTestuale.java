package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class ContenutoTestuale extends Contenuto {
    @JsonProperty("testo")
    private String testo;



    private ContenutiStati stati;

    public ContenutoTestuale(){}

    public ContenutoTestuale(String testo, boolean pending) {
        super(pending);
        this.testo = testo;
    }

    public ContenutoTestuale(String testo, boolean pending, ContenutiStati stati){
        super(pending);
        this.testo = testo;
        this.stati = stati;
    }


//    @Override
//    public String getContenuto() {
//        return testo;
//    }
}
