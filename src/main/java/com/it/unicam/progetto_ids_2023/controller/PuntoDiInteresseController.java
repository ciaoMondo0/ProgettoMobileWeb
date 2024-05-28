package main.java.com.it.unicam.progetto_ids_2023.controller;

import main.java.com.it.unicam.progetto_ids_2023.dto.PuntoDiInteresseDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Coordinate;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresseCategorie;
import main.java.com.it.unicam.progetto_ids_2023.service.PuntoDiInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/puntodiinteresse")
public class PuntoDiInteresseController {


    @Autowired
    private PuntoDiInteresseService pdiService;

    private PuntoDiInteresseController(PuntoDiInteresseService pdiService){
        this.pdiService = pdiService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPuntoDiInteresse(@RequestBody PuntoDiInteresseDTO puntoDiInteresseDTO)/*, @RequestParam Long utenteId*/
     {
        PuntoDiInteresse puntoFisico = pdiService.addPuntoDiInteresse(puntoDiInteresseDTO);
        return ResponseEntity.ok("Punto di interesse fisico aggiunto con ID: " + puntoFisico.getId());
    }

    @DeleteMapping("/{puntoId}")
    public ResponseEntity<String> eliminaPuntoDiInteresse(@PathVariable Long puntoId) {
        pdiService.eliminaPuntoDiInteresse(puntoId);
        return ResponseEntity.ok("Punto di interesse fisico eliminato con successo");
    }

    @GetMapping("/")
    public List<PuntoDiInteresse> trovaPuntiDiInteresse() {
        return pdiService.getPuntodiInteresse();
    }
}
