package main.java.com.it.unicam.progetto_ids_2023.model.contenuto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Contest {

    private String tematica;

    @OneToMany
    @JoinColumn(name = "contenuto_id")
    private List<Contenuto> contenuti = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "invito_id")
    private List<Invito> inviti = new ArrayList<>();

    private boolean pubblico;

    @ElementCollection
    private List<String> listaInvitati = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contenuto_id")
    private Contenuto contenutoBase;

    private LocalDateTime inizio;
    private LocalDateTime fine;
    private Boolean closed;

    public Contest(String tematica, boolean pubblico) {
        this.tematica = tematica;
        this.pubblico = pubblico;
        this.closed = false;
        if (!pubblico)
            this.listaInvitati = new ArrayList<>();
    }

    public Contest(String tematica, boolean pubblico, LocalDateTime inizio, LocalDateTime fine) {
        this.tematica = tematica;
        this.pubblico = pubblico;
        this.inizio = inizio;
        this.fine = fine;
    }
}
