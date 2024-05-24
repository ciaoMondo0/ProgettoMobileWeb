package main.java.com.it.unicam.progetto_ids_2023.model.factory;

import main.java.com.it.unicam.progetto_ids_2023.dto.ItinerarioDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Itinerario;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.repository.PuntoDiInteresseRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.PuntoFisicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItinerarioFactory {


    private final PuntoDiInteresseRepository puntoDiInteresseRepository;
    public ItinerarioFactory(PuntoDiInteresseRepository puntoDiInteresseRepository){
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
    }

    public Itinerario createItinerarioFromDTO(ItinerarioDTO itinerarioDTO) {
        List<PuntoDiInteresse> puntiDiInteresse = new ArrayList<>();
        for (Long poiId : itinerarioDTO.poiId()) {
            PuntoDiInteresse puntoDiInteresse = puntoDiInteresseRepository.findById(poiId)
                    .orElseThrow(() -> new IllegalArgumentException("Punto di interesse con ID " + poiId + " non trovato"));
            puntiDiInteresse.add(puntoDiInteresse);
        }

        return new Itinerario(itinerarioDTO.nome(), itinerarioDTO.descrizione(), puntiDiInteresse);
    }
}
