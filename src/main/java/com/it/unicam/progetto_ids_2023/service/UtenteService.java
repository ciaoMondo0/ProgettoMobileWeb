package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import com.it.unicam.progetto_ids_2023.model.factory.UtenteFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.PuntoFisicoRepository;
import com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtenteService {

    //  private UtenteRepository


    @Autowired
    private PuntoFisicoRepository puntoDiInteresseRepository;
    private UtenteRepository utenteRepository;

    private UtenteFactory utenteFactory;


    public UtenteService(PuntoFisicoRepository puntoDiInteresseRepository, UtenteRepository utenteRepository, UtenteFactory utenteFactory) {
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.utenteRepository = utenteRepository;
        this.utenteFactory = utenteFactory;
    }


    public List<PuntoFisico> trovaPuntiDiInteresse(String searchString) {
        return puntoDiInteresseRepository.findByNomeContainingIgnoreCase(searchString);
    }


    public void assegnaRuolo(Long id, Ruolo ruolo) {
        Utente utente = utenteRepository.findById(id).orElseThrow();
        utente.setRuolo(ruolo);
        utenteRepository.save(utente);

    }

    public Utente login(String email, String password) {
        // Cerca l'utente nel repository in base all'email
      /*  Utente utente = utenteRepository.findByEmail(email);

        // Verifica se l'utente esiste e se la password è corretta
        if (utente != null && utente.getPassword().equals(password)) {
            return utente; // Restituisci l'utente se il login ha avuto successo
        } else {
            return null; // Restituisci null se le credenziali sono sbagliate
        }*/
        return null;
    }

    public void registrazione(UtenteDTO utenteDTO) {
        Utente utente = utenteFactory.createUtente(utenteDTO);
        utenteRepository.save(utente);

    }

    public void cancellaUtente(Long utenteId) {
        utenteRepository.findById(utenteId).orElseThrow();
        utenteRepository.deleteById(utenteId);
    }


    public void salvaInformazioni() {

    }

    public List<Utente> getAll() {
        return utenteRepository.findAll();
    }


}