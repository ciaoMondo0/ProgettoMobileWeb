package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresseCategorie;
import com.it.unicam.progetto_ids_2023.service.PuntoDiInteresseService;
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
    public ResponseEntity<String> addPuntoDiInteresse(@RequestParam String nome,
                                                      @RequestParam String descrizione, @RequestParam PuntoDiInteresseCategorie categorie,
                                                      @RequestParam Long comuneId
    ) {
        PuntoDiInteresse puntoFisico = pdiService.addPuntoDiInteresse(nome, descrizione, categorie, comuneId);
        return ResponseEntity.ok("Punto di interesse fisico aggiunto con ID: " + puntoFisico.getId());
    }

    @DeleteMapping("/{puntoId}")
    public ResponseEntity<String> eliminaPuntoDiInteresse(@PathVariable Long puntoId) {
        pdiService.eliminaPuntoDiInteresse(puntoId);
        return ResponseEntity.ok("Punto di interesse fisico eliminato con successo");
    }

    @GetMapping("/puntodiinteresse/puntidiinteresse")
    public List<PuntoDiInteresse> trovaPuntiDiInteresse() {
        return pdiService.getPuntodiInteresse();
    }
}
