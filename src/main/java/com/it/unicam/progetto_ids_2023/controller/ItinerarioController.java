package main.java.com.it.unicam.progetto_ids_2023.controller;

import main.java.com.it.unicam.progetto_ids_2023.dto.ItinerarioDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Itinerario;
import main.java.com.it.unicam.progetto_ids_2023.service.ItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itinerari")
public class ItinerarioController {

    private ItineraryService itinerarioService;

    public ItinerarioController(ItineraryService itinerarioService){
        this.itinerarioService = itinerarioService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createItinerario(@RequestBody ItinerarioDTO itinerarioDTO) {
        itinerarioService.createItinerario(itinerarioDTO);
        return ResponseEntity.ok("Itinerario creato con successo");
    }

    @PutMapping("/{itinerarioId}/add-pdi/{puntoDiInteresseId}")
    public ResponseEntity<String> aggiungiPuntoDiInteresse(@PathVariable Long itinerarioId, @PathVariable Long puntoDiInteresseId) {
        itinerarioService.aggiungiPuntoDiInteresse(itinerarioId, puntoDiInteresseId);
        return ResponseEntity.ok("Punto di interesse aggiunto all'itinerario con successo");
    }

    @GetMapping("/getitinerari")
    public List<Itinerario> getContenuto(){
        return itinerarioService.getItinerari();
    }

}
