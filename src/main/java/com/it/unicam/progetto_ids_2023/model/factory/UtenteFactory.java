package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.stereotype.Service;

@Service
public class UtenteFactory {

    private final UtenteRepository utenteRepository;

    public UtenteFactory(UtenteRepository utenteRepository){
        this.utenteRepository = utenteRepository;
    }

    public Utente createUtente(UtenteDTO utenteDTO){
        return null;
    }
}
