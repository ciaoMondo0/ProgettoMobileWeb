package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PuntoFisico extends PuntoDiInteresse {
    double latitudine;
    double longitudine;


    public PuntoFisico(){}

    @Autowired
    public PuntoFisico(String nome, String descrizione, double latitudine, double longitudine) {
        super(nome,descrizione);
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.contenuti = new ArrayList<>();
    }


    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

//    @Override
//    public List<Contenuto> getContenuti() {
//        return contenuti;
//    }
//
//    public void setContenuti(List<Contenuto> contenuti) {
//        this.contenuti = contenuti;
//    }
}

