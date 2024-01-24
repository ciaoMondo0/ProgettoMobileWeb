package com.it.unicam.progetto_ids_2023.utenti;

import com.it.unicam.progetto_ids_2023.Observer;

import java.util.ArrayList;
import java.util.List;

public class GestorePiattaforma extends Utente implements Observer {
    private final Ruolo ruolo = Ruolo.GESTORE_PIATTAFORMA;
    private List<Richiesta> richieste;

    public GestorePiattaforma(){}
    public GestorePiattaforma(String nome, String email){
        super(nome,email);
        this.richieste = new ArrayList<>();
    }

    public Ruolo getRuolo(){
        return ruolo;
    }

    public List<Richiesta> getRichieste() {
        return richieste;
    }

    public void setRichieste(List<Richiesta> richieste) {
        this.richieste = richieste;
    }

    @Override
    public void update() {
        System.out.println("Un utente ha effettuato una richiesta");
    }
}
