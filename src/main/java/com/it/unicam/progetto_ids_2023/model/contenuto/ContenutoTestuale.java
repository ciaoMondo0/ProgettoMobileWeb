package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import jakarta.persistence.Entity;

@Entity
public class ContenutoTestuale extends Contenuto {
    @JsonProperty("testo")
    private String testo;

    private String nome;
    private ContenutiStati stati;

    public ContenutoTestuale(){}



    public ContenutoTestuale(String testo,  ContenutiStati stati, String nome){
        super(nome, stati);
        this.testo = testo;
        this.stati = stati;
    }

    public ContenutoTestuale(Long id, Utente utente, String testo,  ContenutiStati stati) {
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
