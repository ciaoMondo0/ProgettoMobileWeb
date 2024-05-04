package com.it.unicam.progetto_ids_2023.service;


import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresseCategorie;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import com.it.unicam.progetto_ids_2023.repository.PuntoDiInteresseRepository;
import com.it.unicam.progetto_ids_2023.repository.PuntoFisicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoDiInteresseService {

    private PuntoFisicoRepository puntoFisicoRepository;

    private PuntoDiInteresseRepository puntoDiInteresseRepository;
    private ComuneRepository comuneRepository;


    public PuntoDiInteresseService(PuntoFisicoRepository puntoFisicoRepository, PuntoDiInteresseRepository puntoDiInteresseRepository, ComuneRepository comuneRepository){
        this.puntoFisicoRepository = puntoFisicoRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.comuneRepository = comuneRepository;
    }





    public PuntoDiInteresse addPuntoDiInteresse(String nome, String descrizione, PuntoDiInteresseCategorie categorie, Long comuneId) {
        PuntoDiInteresse puntoDiInteresse = new PuntoDiInteresse(nome, descrizione, categorie);
        Comune comune = comuneRepository.findById(comuneId).orElseThrow();
        puntoDiInteresse.setComune(comune);
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