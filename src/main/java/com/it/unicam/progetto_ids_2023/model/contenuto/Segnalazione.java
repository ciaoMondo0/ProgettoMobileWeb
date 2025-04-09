package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Segnalazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contenuto_id")
    private Contenuto contenuto;

    private String testoSegnalazione;
    private StatoSegnalazioni statoSegnalazioni;

    public Segnalazione(Contenuto contenuto, String testoSegnalazione, StatoSegnalazioni statoSegnalazioni) {
        this.contenuto = contenuto;
        this.testoSegnalazione = testoSegnalazione;
        this.statoSegnalazioni = statoSegnalazioni;
    }

    public Segnalazione(Long id, Contenuto contenuto, String testoSegnalazione, StatoSegnalazioni statoSegnalazioni) {
        this.id = id;
        this.contenuto = contenuto;
        this.testoSegnalazione = testoSegnalazione;
        this.statoSegnalazioni = statoSegnalazioni;
    }

}
