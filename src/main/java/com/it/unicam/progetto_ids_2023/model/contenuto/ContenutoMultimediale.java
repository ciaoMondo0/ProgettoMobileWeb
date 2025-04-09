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
public class ContenutoMultimediale extends Contenuto {

    @JsonProperty("filepath")
    private String filePath;

    // Il costruttore passa i parametri al costruttore del padre
    public ContenutoMultimediale(String filePath, ContenutiStati stati, String nome) {
        super(nome, stati);
        this.filePath = filePath;
    }
}
