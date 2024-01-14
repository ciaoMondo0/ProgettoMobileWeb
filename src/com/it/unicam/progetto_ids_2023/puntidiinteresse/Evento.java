package com.it.unicam.progetto_ids_2023.puntidiinteresse;

import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Evento implements PuntoDiInteresse{

    private String nome;
    private Set<PuntoDiInteresse> puntiDiInteresse;
    private LocalDateTime inizio;
    private LocalDateTime fine;

    public Evento(Set<PuntoDiInteresse> puntiDiInteresse, LocalDateTime inizio, LocalDateTime fine) {
        this.puntiDiInteresse = new HashSet<>();
        this.inizio = inizio;
        this.fine = fine;
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
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Contenuto> getContenuti() {
        List<Contenuto> contenutiEvento = new ArrayList<>();
        for (PuntoDiInteresse punto : puntiDiInteresse) {
            contenutiEvento.addAll(punto.getContenuti());
        }
        return contenutiEvento;
    }
}
