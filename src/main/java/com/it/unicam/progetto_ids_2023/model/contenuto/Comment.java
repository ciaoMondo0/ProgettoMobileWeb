package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Contenuto contenuto;

    @JsonIgnore
    @ManyToOne
    private Utente utente;

    @Column(columnDefinition = "TEXT")
    private String testo;
}
