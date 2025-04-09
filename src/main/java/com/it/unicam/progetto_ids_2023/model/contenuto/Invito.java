package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Invito {

    @Id
    @GeneratedValue
    private Long id;

    private String emailDestinatario;
    private String contenuto;

    @ManyToOne
    @JoinColumn(name = "contest_id")
    private Contest contest;

    @OneToMany
    @JoinColumn(name = "utente_id")
    private List<Utente> utente;

    public Invito(String contenuto) {
        this.contenuto = contenuto;
    }
}
