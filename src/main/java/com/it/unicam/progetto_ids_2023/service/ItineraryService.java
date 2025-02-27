package main.java.com.it.unicam.progetto_ids_2023.service;

import main.java.com.it.unicam.progetto_ids_2023.dto.ItinerarioDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Itinerario;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.repository.ItinerarioRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.PuntoDiInteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItineraryService {

    private final ItinerarioRepository itinerarioRepository;
    private final PuntoDiInteresseRepository puntoDiInteresseRepository;

    @Autowired
    public ItineraryService(ItinerarioRepository itinerarioRepository, PuntoDiInteresseRepository puntoDiInteresseRepository) {
        this.itinerarioRepository = itinerarioRepository;
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
    }




    public Itinerario createItinerario(ItinerarioDTO itinerarioDTO) {
        List<PuntoDiInteresse> puntiDiInteresse = new ArrayList<>();
        for (Long poiId : itinerarioDTO.poiId()) {
            PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(poiId)
                    .orElseThrow(() -> new IllegalArgumentException("Punto di interesse con ID " + poiId + " non trovato"));
            puntiDiInteresse.add(puntoDiInteresse);
        }

        return new Itinerario(itinerarioDTO.nome(), itinerarioDTO.descrizione(), puntiDiInteresse);
    }

    public void aggiungiPuntoDiInteresse(Long itinerarioId, Long puntoDiInteresseId) {
        Itinerario itinerario = itinerarioRepository.findById(itinerarioId)
                .orElseThrow(() -> new IllegalArgumentException("Itinerario non trovato"));
        PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(puntoDiInteresseId)
                .orElseThrow(() -> new IllegalArgumentException("Punto di interesse non trovato"));
        itinerario.getPuntoDiInteresse().add(puntoDiInteresse);
        itinerarioRepository.save(itinerario);
    }

    public List<Itinerario> getItinerari(){
        return this.itinerarioRepository.findAll();
    }
}
