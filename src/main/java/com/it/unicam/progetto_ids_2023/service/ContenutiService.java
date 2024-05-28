package main.java.com.it.unicam.progetto_ids_2023.service;

import main.java.com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.*;
import main.java.com.it.unicam.progetto_ids_2023.model.factory.ContentFactory;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.*;
import main.java.com.it.unicam.progetto_ids_2023.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Ruolo;

import java.time.LocalDateTime;
import java.util.List;


@Service

public class ContenutiService {

    private ContentFactory contenutoFactory;
    private ContenutoMultimedialeRepository multiRepo;
    private ContenutoRepository contenutoRepository;
    private ComuneRepository comuneRepository;
    private UtenteRepository utenteRepository;
    private PuntoDiInteresseRepository puntoDiInteresseRepository;
    private static final Logger logger = LoggerFactory.getLogger(ContenutiService.class);


    @Autowired
    public ContenutiService(ContenutoRepository contenutoRepository, ContenutoMultimedialeRepository multiRepo, ContentFactory contenutoFactory, UtenteRepository utenteRepository
            , ComuneRepository comuneRepository, PuntoDiInteresseRepository puntoDiInteresseRepository) {

        this.contenutoRepository = contenutoRepository;
        this.multiRepo = multiRepo;
        this.contenutoFactory = contenutoFactory;
        this.utenteRepository = utenteRepository;
        this.comuneRepository = comuneRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
    }

    public void addContenuto(ContenutoDTO contenutoDTO) {

        Contenuto contenuto = contenutoFactory.createContenuto(contenutoDTO);


        Utente utente = utenteRepository.findById(contenutoDTO.utenteId())
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));

        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findByNomeContainingIgnoreCase(contenuto.getNome()).getFirst();


        contenuto.setPuntoDiInteresse(puntoDiInteresse);
        contenuto.setUtente(utente);

        contenutoRepository.save(contenuto);


    }

        /*

        if (contenuto.getUtente().getRuolo() == Ruolo.CONTRIBUTOR_AUTORIZZATO || contenuto.getUtente().getRuolo() == Ruolo.CURATORE) {
            contenuto.setPending(false);
            contenuto.setStati(ContenutiStati.ACCETTATO);
            contenutoRepository.save(contenuto);

        } else if (contenuto.getUtente().getRuolo() == Ruolo.CONTRIBUTOR) {
            contenuto.setPending(true);
            contenuto.setStati(ContenutiStati.PENDING);
           // comune.getContenuto().add(contenuto);
           // comuneRepository.save(comune);
            contenutoRepository.save(contenuto);

        } else {
            throw new IllegalArgumentException();
        }
*/


    public void accettaContenuto(Long contenutoId) {
        Contenuto contenuto = contenutoRepository.findById(contenutoId).orElseThrow();
        if (contenuto.getStati().equals((ContenutiStati.PENDING))) {
            contenuto.setStati(ContenutiStati.ACCETTATO);
            contenutoRepository.save(contenuto);
        } else {
            throw new IllegalArgumentException("Contenuto già accettato");
        }

    }

    public void deleteContenuto(Long contenutoId) {

        Contenuto contenuto = contenutoRepository.findById(contenutoId).orElseThrow();

        contenutoRepository.delete(contenuto);

    }


    public void rifiutaContenuto(Long contenutoId) {

        Contenuto contenuto = contenutoRepository.findById(contenutoId).orElseThrow();
        if (contenuto.isPending()) {

            contenutoRepository.delete(contenuto);

        } else {
            throw new IllegalArgumentException();
        }


    }


    public List<Contenuto> getContenuti() {
        return contenutoRepository.findAll();


    }

    public List<Contenuto> trovaContenutiPerNome(String nome) {
        return contenutoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Contenuto> trovaContenutiPerStato(ContenutiStati stati) {
        return contenutoRepository.findAllByPending(stati);
    }

    public List<Contenuto> trovaContenutiPerIntervallo(LocalDateTime start, LocalDateTime end) {
        return contenutoRepository.findAllByDateBetween(start, end);
    }

    public List<Contenuto> getContenutiByPuntoDiInteresse(Long puntoDiInteresseId) {
        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(puntoDiInteresseId)
                .orElseThrow(() -> new IllegalArgumentException("Punto di interesse non trovato"));

        return contenutoRepository.findByPuntoDiInteresse(puntoDiInteresse);
    }

    /*
    public void accettaContenuto(Long id) {
        Contenuto contenuto = contenutoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Contenuto non trovato"));
        if (contenuto.getStati() == ContenutiStati.PENDING) {
            contenuto.setStati(ContenutiStati.ACCETTATO);
            contenutoRepository.save(contenuto);
        } else {
            throw new IllegalArgumentException("Contenuto già accettato");
        }
    }

    public void rifiutaContenuto(Long id) {
        Contenuto contenuto = contenutoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Contenuto non trovato"));
        if (contenuto.getStati() == ContenutiStati.PENDING) {
            contenuto.setStati(ContenutiStati.RIFIUTATO);
            contenutoRepository.save(contenuto);
        } else {
            throw new IllegalArgumentException("Contenuto già rifiutato");
        }
    }
     */
}









