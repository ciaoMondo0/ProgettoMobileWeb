package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PuntoLogico extends PuntoDiInteresse {



    public PuntoLogico(){}
    public PuntoLogico(String nome, String descrizione, PuntoDiInteresseCategorie categorie) {
        super(nome,descrizione, categorie);
    }

/*
 @Override
    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }
 */
}