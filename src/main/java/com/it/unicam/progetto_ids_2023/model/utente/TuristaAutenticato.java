package com.it.unicam.progetto_ids_2023.model.utente;

import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import jakarta.persistence.*;


@Entity
public class TuristaAutenticato extends Utente{
    private final Ruolo ruolo = Ruolo.TURISTA_AUTENTICATO;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "puntoDiInteresse_id")
    private PuntoDiInteresse puntoDiInteresse;
    @Id
    private Long id;

    public TuristaAutenticato(String nome, String email, PuntoDiInteresse puntoDiInteresse){
        super(nome,email);
        puntoDiInteresse = new PuntoDiInteresse();
    }

    public TuristaAutenticato() {

    }

    @Override
    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setPuntoDiInteresse(PuntoDiInteresse puntoDiInteresse){
        this.puntoDiInteresse = puntoDiInteresse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}