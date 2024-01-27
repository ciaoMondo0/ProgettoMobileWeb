package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.service.ComuneService;
import com.it.unicam.progetto_ids_2023.service.PuntoDiInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comuni")
public class ComuneController {

    private PuntoDiInteresseService puntoDiInteresseService;
    private ComuneService comuneService;

    @Autowired
    public ComuneController(PuntoDiInteresseService puntoDiInteresseService, ComuneService comuneService) {
        this.puntoDiInteresseService = puntoDiInteresseService;
        this.comuneService = comuneService;
    }

    @GetMapping("/")
    public List<Comune> getComuni(){
        comuneService.popolaRepository();
        return comuneService.getComuni();
    }

    @GetMapping("/{id}/contenuti")
    public List<Contenuto> getContenutiComune(@PathVariable Long id){
        return comuneService.getContenutiComune(id);
    }

    @PostMapping("/{id}/addcontenuto")
    public void addContenutoComune(@PathVariable Long id, @RequestBody Contenuto contenuto){
        comuneService.addContenutoComune(id,contenuto);
    }

    @PostMapping("/addcomune")
    public Comune addComune(@RequestParam String nome, @RequestParam String descrizione){
        return comuneService.addComune(nome,descrizione);
    }

}
