package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.factory.UtenteFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.ContenutoBaseRepository;
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

    private ContenutoBaseRepository contenutoBaseRepository;

    public UtenteService(PuntoFisicoRepository puntoDiInteresseRepository, UtenteRepository utenteRepository, UtenteFactory utenteFactory) {
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.utenteRepository = utenteRepository;
        this.utenteFactory = utenteFactory;
        this.contenutoBaseRepository = contenutoBaseRepository;
    }


    public List<PuntoFisico> trovaPuntiDiInteresse(String searchString) {
        return puntoDiInteresseRepository.findByNomeContainingIgnoreCase(searchString);
    }


    public List<ContenutoBase> trovaContenuti(String searchString) {
        //  return contenutoBaseRepository.findByNomeContainingIgnoreCase(searchString);
        return null;
    }


    public void assegnaRuolo(Long id, Ruolo ruolo) {
        Utente utente = utenteRepository.findById(id).orElseThrow();
        utente.setRuolo(ruolo);
        utenteRepository.save(utente);

    }

    public Utente login(String email, String password) {
        // Cerca l'utente nel repository in base all'email
        Utente utente = utenteRepository.findByEmail(email);

        // Verifica se l'utente esiste e se la password è corretta
        if (utente != null && utente.getPassword().equals(password)) {
            return utente; // Restituisci l'utente se il login ha avuto successo
        } else {
            return null; // Restituisci null se le credenziali sono sbagliate
        }

    }

    public void registrazione(UtenteDTO utenteDTO) {
        Utente utente = utenteFactory.createUtente(utenteDTO);
        utenteRepository.save(utente);

    }

    public void cancellaUtente(Long utenteId) {
        utenteRepository.findById(utenteId).orElseThrow();
        utenteRepository.deleteById(utenteId);
    }

    public void aggiungiPreferito(Long utenteId, ContenutoBase contenuto) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        utente.getPreferitiContenuti().add(contenuto);
        utenteRepository.save(utente);
    }

    public void rimuoviPreferito(Long utenteId, ContenutoBase contenuto) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        utente.getPreferitiContenuti().remove(contenuto);
        utenteRepository.save(utente);
    }

    public void aggiungiPreferito(Long utenteId, PuntoDiInteresse puntoDiInteresse) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        utente.getPreferitiPuntiDiInteresse().add(puntoDiInteresse);
        utenteRepository.save(utente);
    }

    public void rimuoviPreferito(Long utenteId, PuntoDiInteresse puntoDiInteresse) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        utente.getPreferitiPuntiDiInteresse().remove(puntoDiInteresse);
        utenteRepository.save(utente);
    }

    public List<Utente> getAll(){
        return utenteRepository.findAll();
    }

}