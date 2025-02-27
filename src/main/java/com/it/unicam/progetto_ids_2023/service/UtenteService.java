package main.java.com.it.unicam.progetto_ids_2023.service;

import main.java.com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.PuntoDiInteresseRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final ContenutoRepository contenutoRepository;
    private final PuntoDiInteresseRepository puntoDiInteresseRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UtenteService(UtenteRepository utenteRepository,
                         ContenutoRepository contenutoRepository,
                         PuntoDiInteresseRepository puntoDiInteresseRepository,
                         BCryptPasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.contenutoRepository = contenutoRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void assegnaRuolo(Long id, Ruolo ruolo) {
        Utente utente = utenteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + id));
        utente.setRuolo(ruolo);
        utenteRepository.save(utente);
    }

    public void registrazione(UtenteDTO utenteDTO) {
        Utente utente = new Utente();
        utente.setRuolo(Ruolo.TURISTA_AUTENTICATO);
        utente.setEmail(utenteDTO.email());
        utente.setNome(utenteDTO.username());
        String encodedPassword = passwordEncoder.encode(utenteDTO.password());
        utente.setPassword(encodedPassword);
        utenteRepository.save(utente);
    }

    public void cancellaUtente(Long utenteId) {
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + utenteId));
        utenteRepository.delete(utente);
    }

    public void aggiungiPreferitoContenuto(Long utenteId, Long contenutoId) {
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + utenteId));
        Contenuto contenuto = contenutoRepository.findById(contenutoId)
                .orElseThrow(() -> new NoSuchElementException("Contenuto non trovato con id: " + contenutoId));
        utente.getPreferitiContenuti().add(contenuto);
        utenteRepository.save(utente);
    }

    public void rimuoviPreferitoContenuto(Long utenteId, Long contenutoId) {
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + utenteId));
        Contenuto contenuto = contenutoRepository.findById(contenutoId)
                .orElseThrow(() -> new NoSuchElementException("Contenuto non trovato con id: " + contenutoId));
        if (!utente.getPreferitiContenuti().remove(contenuto)) {
            throw new IllegalArgumentException("Il contenuto non era presente tra i preferiti");
        }
        utenteRepository.save(utente);
    }

    public void aggiungiPreferitoPuntoDiInteresse(Long utenteId, Long puntoDiInteresseId) {
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + utenteId));
        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(puntoDiInteresseId)
                .orElseThrow(() -> new NoSuchElementException("Punto di interesse non trovato con id: " + puntoDiInteresseId));
        utente.getPreferitiPuntiDiInteresse().add(puntoDiInteresse);
        utenteRepository.save(utente);
    }

    public void rimuoviPreferitoPuntoDiInteresse(Long utenteId, Long puntoDiInteresseId) {
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + utenteId));
        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(puntoDiInteresseId)
                .orElseThrow(() -> new NoSuchElementException("Punto di interesse non trovato con id: " + puntoDiInteresseId));
        if (!utente.getPreferitiPuntiDiInteresse().remove(puntoDiInteresse)) {
            throw new IllegalArgumentException("Il punto di interesse non era presente tra i preferiti");
        }
        utenteRepository.save(utente);
    }

    public List<Utente> getAll() {
        return utenteRepository.findAll();
    }
}
