package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.factory.UtenteFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtenteService {

    //  private UtenteRepository



    @Autowired

    private UtenteRepository utenteRepository;

    private UtenteFactory utenteFactory;

    private ContenutoRepository contenutoBaseRepository;

    private PuntoDiInteresseRepository puntoDiInteresseRepository;

    public UtenteService(UtenteRepository utenteRepository, UtenteFactory utenteFactory, ContenutoRepository contenutoRepository, PuntoDiInteresseRepository puntoDiInteresseRepository){

        this.utenteRepository = utenteRepository;
        this.utenteFactory = utenteFactory;
        this.contenutoBaseRepository = contenutoBaseRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
    }



    public List<PuntoDiInteresse> trovaPuntiDiInteresse(String searchString) {
        return puntoDiInteresseRepository.findByNomeContainingIgnoreCase(searchString);
    }



    public List<ContenutoBase> trovaContenuti(String searchString){
        //  return contenutoBaseRepository.findByNomeContainingIgnoreCase(searchString);
        return null;
    }






    public void assegnaRuolo(Long id, Ruolo ruolo){
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

    public void registrazione(UtenteDTO utenteDTO){
        Utente utente = utenteFactory.createUtente(utenteDTO);
        utenteRepository.save(utente);

    }

    public void cancellaUtente(Long utenteId){
        utenteRepository.findById(utenteId).orElseThrow();
        utenteRepository.deleteById(utenteId);
    }

    public void aggiungiPreferitoContenuto(Long utenteId, Long contenutoId) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        Contenuto contenuto = contenutoBaseRepository.findById(contenutoId).orElseThrow();
        utente.getPreferitiContenuti().add(contenuto);
        utenteRepository.save(utente);
    }

    public void rimuoviPreferitoContenuto(Long utenteId, Long contenutoId) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        Contenuto contenuto = contenutoBaseRepository.findById(contenutoId).orElseThrow();
        if(utente.getPreferitiContenuti().contains(contenuto)) {
            utente.getPreferitiContenuti().remove(contenuto);
        } else {
            throw new IllegalArgumentException();
        }
        utenteRepository.save(utente);
    }

    public void aggiungiPreferitoPuntoDiInteresse(Long utenteId, Long puntoDiInteresseId) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(puntoDiInteresseId).orElseThrow();
        utente.getPreferitiPuntiDiInteresse().add(puntoDiInteresse);
        utenteRepository.save(utente);
    }

    public void rimuoviPreferitoPuntoDiInteresse(Long utenteId,  Long puntoDiInteresseId) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(puntoDiInteresseId).orElseThrow();
        if(utente.getPreferitiPuntiDiInteresse().contains(puntoDiInteresse)) {
            utente.getPreferitiPuntiDiInteresse().remove(puntoDiInteresse);
        } else {
            throw new IllegalArgumentException();
        }
        utenteRepository.save(utente);
    }




    public void salvaInformazioni(){

    }


    public List<Utente> getAll() {
        return utenteRepository.findAll();
    }
}
