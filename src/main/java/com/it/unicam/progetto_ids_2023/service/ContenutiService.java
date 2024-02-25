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

import java.util.List;


@Service

public class ContenutiService {

    private ContentFactory contenutoFactory;
    private ContenutoMultimedialeRepository multiRepo;
    private ContenutoBaseRepository testoRepo;
    private UtenteRepository utenteRepository;

    @Autowired
    public ContenutiService(ContenutoBaseRepository testoRepo, ContenutoMultimedialeRepository multiRepo, ContentFactory contenutoFactory, UtenteRepository utenteRepository) {

        this.testoRepo = testoRepo;
        this.multiRepo = multiRepo;
        this.contenutoFactory = contenutoFactory;
        this.utenteRepository = utenteRepository;
    }

    public void addContenuto(ContenutoBaseDTO contenutoDTO) {
        ContenutoBase contenuto = contenutoFactory.createContenuto(contenutoDTO);
        Utente utenti = new Utente(Ruolo.CONTRIBUTOR_AUTORIZZATO, "john@example.com", "john_doe");
        utenteRepository.save(utenti);

        Utente utente = utenteRepository.findById(1L).orElseThrow(() -> new RuntimeException("Utente not found"));
        contenuto.setUtente(utente);


        if (contenuto.getUtente().getRuolo() == Ruolo.CONTRIBUTOR_AUTORIZZATO || contenuto.getUtente() instanceof Curatore) {
            //   contenuto.setComune(contenutoDTO.comune());
            //  contenuto.setPuntoDiInteresse(contenutoDTO.puntoDiInteresse());
            contenuto.setPending(false);
            testoRepo.save(contenuto);

            //     } else if (contenuto.getUtente() instanceof Contributor) {
            //    contenuto.setComune(contenutoDTO.comune());
            //  contenuto.setPuntoDiInteresse(contenutoDTO.puntoDiInteresse());
            //       contenuto.setPending(true);
            //   contenuto.setUtente(contenutoDTO.utente());
            //     testoRepo.save(contenuto);

        } else {
            throw new IllegalArgumentException();
        }


    }


    public void accettaContenutoTestuale(Long testoId) {
        ContenutoBase contenutoBase = testoRepo.findById(testoId).orElseThrow();
        if (contenutoBase.getStati().equals((ContenutiStati.PENDING))) {
            contenutoBase.setStati(ContenutiStati.ACCETTATO);
            testoRepo.save(contenutoBase);
        } else {
            throw new IllegalArgumentException("Contenuto già accettato");
        }

    }

    public void deleteContenutoTestuale(Long multiMediaid, Long testoId) {
        ContenutoMultimediale multimedia = multiRepo.findById(multiMediaid).orElseThrow();
        ContenutoBase testuale = testoRepo.findById(testoId).orElseThrow();
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

        ContenutoBase contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        if (contenutoTestuale.isPending()) {
            contenutoTestuale.setStato(ContenutiStati.RIFIUTATO);
            testoRepo.save(contenutoTestuale);
        } else {
            throw new IllegalArgumentException();
        }


    }

    public void rifiutaContenutoMultimediale(Long contenutoTestoId) {

        ContenutoBase contenutoTestuale = testoRepo.findById(contenutoTestoId).orElseThrow();
        if (contenutoTestuale.isPending()) {
            contenutoTestuale.setStato(ContenutiStati.RIFIUTATO);
            testoRepo.save(contenutoTestuale);
        } else {
            throw new IllegalArgumentException();
        }


    }

    public List<ContenutoBase> getContenuti() {
        return testoRepo.findAll();


    }
}








