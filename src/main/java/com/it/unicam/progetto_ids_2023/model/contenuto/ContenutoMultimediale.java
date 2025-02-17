package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class ContenutoMultimediale extends Contenuto {
    /* stringa che contiene il percorso del file */
    @JsonProperty("filepath")
    private String filePath;
    private String nome;
    private  ContenutiStati stati;

    public ContenutoMultimediale(){}

    public ContenutoMultimediale(String filePath,   ContenutiStati stati,  String nome){
        super(nome, stati);
        this.filePath = filePath;

    }

//    @Override
//    public String getContenuto() {
//        return filePath;
//    }
}