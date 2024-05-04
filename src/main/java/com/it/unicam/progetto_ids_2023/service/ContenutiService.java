package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.*;
import com.it.unicam.progetto_ids_2023.model.factory.ContentFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.utente.*;
import com.it.unicam.progetto_ids_2023.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;

import java.time.LocalDateTime;
import java.util.List;


@Service

public class ContenutiService {

    private ContentFactory contenutoFactory;
    private ContenutoMultimedialeRepository multiRepo;
    private ContenutoRepository contenutoRepository;
    private ComuneRepository comuneRepository;
    private UtenteRepository utenteRepository;

    @Autowired
    public ContenutiService(ContenutoRepository contenutoRepository, ContenutoMultimedialeRepository multiRepo, ContentFactory contenutoFactory, UtenteRepository utenteRepository
            , ComuneRepository comuneRepository) {

        this.contenutoRepository = contenutoRepository;
        this.multiRepo = multiRepo;
        this.contenutoFactory = contenutoFactory;
        this.utenteRepository = utenteRepository;
        this.comuneRepository = comuneRepository;
    }

    public void addContenuto(ContenutoDTO contenutoDTO, Long utenteId, Long comuneId) {
        Contenuto contenuto = contenutoFactory.createContenuto(contenutoDTO);
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));
        Comune comune = comuneRepository.findById(comuneId).orElseThrow();
        contenuto.setComune(comune);

        contenuto.setUtente(utente);


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


    }


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
        if (contenuto.getStati().equals(ContenutiStati.RIFIUTATO)) {
            contenutoRepository.delete(contenuto);
        } else {
            throw new IllegalArgumentException();
        }
    }




    public void rifiutaContenuto(Long contenutoId) {

        Contenuto contenuto = contenutoRepository.findById(contenutoId).orElseThrow();
        if (contenuto.isPending()) {
            contenuto.setStato(ContenutiStati.RIFIUTATO);
            contenutoRepository.save(contenuto);
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









