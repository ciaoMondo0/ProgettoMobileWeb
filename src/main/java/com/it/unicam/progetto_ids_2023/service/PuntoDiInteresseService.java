package main.java.com.it.unicam.progetto_ids_2023.service;


import main.java.com.it.unicam.progetto_ids_2023.dto.PuntoDiInteresseDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.*;
import main.java.com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.PuntoDiInteresseRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoDiInteresseService {



    private PuntoDiInteresseRepository puntoDiInteresseRepository;
    private ComuneRepository comuneRepository;

    private UtenteRepository utenteRepository;


    public PuntoDiInteresseService( PuntoDiInteresseRepository puntoDiInteresseRepository, ComuneRepository comuneRepository, UtenteRepository utenteRepository){

        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.comuneRepository = comuneRepository;
        this.utenteRepository = utenteRepository;
    }





    public PuntoDiInteresse addPuntoDiInteresse(PuntoDiInteresseDTO puntoDiInteresseDTO/* Long utenteId*/) {
        String nome = puntoDiInteresseDTO.nome();
        String descrizione = puntoDiInteresseDTO.descrizione();
        PuntoDiInteresseCategorie categorie = puntoDiInteresseDTO.categorie();
        Coordinate coordinate = puntoDiInteresseDTO.coordinate();

        PuntoDiInteresse puntoDiInteresse = new PuntoDiInteresse(nome, descrizione, categorie, coordinate);
       Comune comune = comuneRepository.findById(puntoDiInteresseDTO.comuneId()).orElseThrow();
      //  Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        puntoDiInteresse.setComune(comune);
        //puntoDiInteresse.setUtente(utente);
       comune.getPuntoDiInteresse().add(puntoDiInteresse);
       comuneRepository.save(comune);


        return puntoDiInteresseRepository.save(puntoDiInteresse);
    }

    public void eliminaPuntoDiInteresse(Long puntoId) {
        puntoDiInteresseRepository.findById(puntoId)
                .orElseThrow(() -> new IllegalArgumentException("Punto di interesse non trovato"));
        puntoDiInteresseRepository.deleteById(puntoId);
    }

    public List<PuntoDiInteresse> getPuntodiInteresse(){
        return puntoDiInteresseRepository.findAll();
    }
}