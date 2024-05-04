package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.ItinerarioDTO;
import com.it.unicam.progetto_ids_2023.model.factory.ItinerarioFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Itinerario;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.repository.ItinerarioRepository;
import com.it.unicam.progetto_ids_2023.repository.PuntoDiInteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {

    private final ItinerarioFactory itinerarioFactory;
    private final ItinerarioRepository itinerarioRepository;
    private final PuntoDiInteresseRepository puntoDiInteresseRepository;

    @Autowired
    public ItineraryService(ItinerarioFactory itinerarioFactory, ItinerarioRepository itinerarioRepository, PuntoDiInteresseRepository puntoDiInteresseRepository) {
        this.itinerarioFactory = itinerarioFactory;
        this.itinerarioRepository = itinerarioRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
    }

    public void createItinerario(ItinerarioDTO itinerarioDTO) {
        Itinerario itinerario = itinerarioFactory.createItinerarioFromDTO(itinerarioDTO);
        itinerarioRepository.save(itinerario);
    }

    public void aggiungiPuntoDiInteresse(Long itinerarioId, Long puntoDiInteresseId) {
        Itinerario itinerario = itinerarioRepository.findById(itinerarioId)
                .orElseThrow(() -> new IllegalArgumentException("Itinerario non trovato"));
        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(puntoDiInteresseId)
                .orElseThrow(() -> new IllegalArgumentException("Punto di interesse non trovato"));
        itinerario.getPuntoDiInteresse().add(puntoDiInteresse);
        itinerarioRepository.save(itinerario);
    }
}
