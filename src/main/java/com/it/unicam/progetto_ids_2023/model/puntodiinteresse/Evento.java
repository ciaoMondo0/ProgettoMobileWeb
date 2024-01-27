package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Evento extends PuntoDiInteresse{
    private Set<PuntoDiInteresse> puntiDiInteresse;
    private LocalDateTime inizio;
    private LocalDateTime fine;

    public Evento(String nome, String descrizione, LocalDateTime inizio, LocalDateTime fine) {
        super(nome,descrizione);
        this.inizio = inizio;
        this.fine = fine;
        this.puntiDiInteresse = new HashSet<>();
    }

    public Set<PuntoDiInteresse> getPuntiDiInteresse() {
        return puntiDiInteresse;
    }

    public void setPuntiDiInteresse(Set<PuntoDiInteresse> puntiDiInteresse) {
        this.puntiDiInteresse = puntiDiInteresse;
    }

    public LocalDateTime getInizio() {
        return inizio;
    }

    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public LocalDateTime getFine() {
        return fine;
    }

    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }

    @Override
    public List<Contenuto> getContenuti() {
        return contenuti;
    }
}
