package com.it.unicam.progetto_ids_2023.service;


import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresseCategorie;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.repository.PuntoDiInteresseRepository;
import com.it.unicam.progetto_ids_2023.repository.PuntoFisicoRepository;
import org.springframework.stereotype.Service;

@Service
public class PuntoDiInteresseService {

    private PuntoFisicoRepository puntoFisicoRepository;

    private PuntoDiInteresseRepository puntoDiInteresseRepository;


    public PuntoDiInteresseService(PuntoFisicoRepository puntoFisicoRepository, PuntoDiInteresseRepository puntoDiInteresseRepository){
        this.puntoFisicoRepository = puntoFisicoRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
    }





    public PuntoDiInteresse addPuntoDiInteresse(String nome, String descrizione, PuntoDiInteresseCategorie categorie) {
        PuntoDiInteresse puntoDiInteresse = new PuntoDiInteresse(nome, descrizione, categorie);
        return puntoDiInteresseRepository.save(puntoDiInteresse);
    }

    public void eliminaPuntoDiInteresse(Long puntoId) {
        puntoDiInteresseRepository.findById(puntoId)
                .orElseThrow(() -> new IllegalArgumentException("Punto di interesse non trovato"));
        puntoDiInteresseRepository.deleteById(puntoId);
    }
}