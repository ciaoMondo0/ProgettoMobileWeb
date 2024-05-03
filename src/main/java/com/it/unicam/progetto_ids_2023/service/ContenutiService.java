package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.ContenutoBaseDTO;
import com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.*;
import com.it.unicam.progetto_ids_2023.model.factory.ContentFactory;
import com.it.unicam.progetto_ids_2023.model.factory.ContenutoFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
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
    private ContenutoRepository testoRepo;
    private ComuneRepository comuneRepository;
    private UtenteRepository utenteRepository;

    @Autowired
    public ContenutiService(ContenutoRepository testoRepo, ContenutoMultimedialeRepository multiRepo, ContentFactory contenutoFactory, UtenteRepository utenteRepository
            , ComuneRepository comuneRepository) {

        this.testoRepo = testoRepo;
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
            testoRepo.save(contenuto);

        } else if (contenuto.getUtente().getRuolo() == Ruolo.CONTRIBUTOR) {
            contenuto.setPending(true);
            contenuto.setStati(ContenutiStati.PENDING);
            testoRepo.save(contenuto);

        } else {
            throw new IllegalArgumentException();
        }


    }


    public void accettaContenutoTestuale(Long testoId) {
        Contenuto contenutoBase = testoRepo.findById(testoId).orElseThrow();
        if (contenutoBase.getStati().equals((ContenutiStati.PENDING))) {
            contenutoBase.setStati(ContenutiStati.ACCETTATO);
            testoRepo.save(contenutoBase);
        } else {
            throw new IllegalArgumentException("Contenuto già accettato");
        }

    }

    public void deleteContenutoTestuale(Long multiMediaid, Long testoId) {
        ContenutoMultimediale multimedia = multiRepo.findById(multiMediaid).orElseThrow();
        Contenuto testuale = testoRepo.findById(testoId).orElseThrow();
        if (testuale.getStati().equals(ContenutiStati.RIFIUTATO)) {
            testoRepo.delete(testuale);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void deleteContenutoMultimediale(Long contenutoMediaId) {
       /* ContenutoMultimediale multimedia = multiRepo.findById(multiMediaid).orElseThrow();
        if(testuale.getStati().equals(ContenutiStati.RIFIUTATO)) {

            testoRepo.delete(testuale);
        } else {
            throw new IllegalArgumentException();
        } */


    }


    public void rifiutaContenutoTestuale(Long contenutoTestoId) {

        Contenuto contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        if (contenutoTestuale.isPending()) {
            contenutoTestuale.setStato(ContenutiStati.RIFIUTATO);
            testoRepo.save(contenutoTestuale);
        } else {
            throw new IllegalArgumentException();
        }


    }

    public void rifiutaContenutoMultimediale(Long contenutoTestoId) {

        Contenuto contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        if (contenutoTestuale.isPending()) {
            contenutoTestuale.setStato(ContenutiStati.RIFIUTATO);
            testoRepo.save(contenutoTestuale);
        } else {
            throw new IllegalArgumentException();
        }


    }

    public List<Contenuto> getContenuti() {
        return testoRepo.findAll();


    }

    public List<Contenuto> trovaContenutiPerNome(String nome) {
        return testoRepo.findByNomeContainingIgnoreCase(nome);
    }

    public List<Contenuto> trovaContenutiPerStato(ContenutiStati stati) {
        return testoRepo.findAllByPending(stati);
    }

    public List<Contenuto> trovaContenutiPerIntervallo(LocalDateTime start, LocalDateTime end) {
        return testoRepo.findAllByDateBetween(start, end);
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









