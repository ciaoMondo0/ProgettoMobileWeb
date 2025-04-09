package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContenutoTestuale extends Contenuto {

    @JsonProperty("testo")
    private String testo;

    public ContenutoTestuale(String testo, ContenutiStati stati, String nome) {
        super(nome, stati);
        this.testo = testo;
    }
}
