package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class ContenutoMultimediale extends Contenuto {
    /* stringa che contiene il percorso del file */
    @JsonProperty("filepath")
    private String filePath;
    private  ContenutiStati stati;

    public ContenutoMultimediale(){}

    public ContenutoMultimediale(String filePath, boolean pending,  ContenutiStati stati,  String nome){
        super(nome, pending, stati );
        this.filePath = filePath;
        this.stati = stati;
    }

//    @Override
//    public String getContenuto() {
//        return filePath;
//    }
}