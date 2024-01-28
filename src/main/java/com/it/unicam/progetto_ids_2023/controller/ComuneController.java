package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoLogico;
import com.it.unicam.progetto_ids_2023.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comuni")
public class ComuneController {
    private ComuneService comuneService;

    @Autowired
    public ComuneController(ComuneService comuneService) {
        this.comuneService = comuneService;
    }


    /*COMUNI*/
    @GetMapping("/")
    public List<Comune> getComuni(){
        comuneService.popolaRepository();
        return comuneService.getComuni();
    }

    @PostMapping("/add/comune")
    public Comune addComune(@RequestParam String nome, @RequestParam String descrizione){
        return comuneService.addComune(nome,descrizione);
    }


    /*CONTENUTI*/
    @GetMapping("/{id}/contenuti")
    public List<Contenuto> getContenutiComune(@PathVariable Long id){
        return comuneService.getContenutiComune(id);
    }

    @PostMapping("/{id}/add/testo")
    public void addContenutoComune(@PathVariable Long id, @RequestParam String testo, @RequestParam boolean pending){
        comuneService.addTestoComune(id,testo,pending);
    }



    /*PUNTI DI INTERESSE*/
    @PostMapping("/{id}/add/poifisico")
    public void addPuntoFisico(@PathVariable Long id, String nome, String descrizione, double latitudine, double longitudine){
        comuneService.addPuntoFisico(id,nome,descrizione,latitudine,longitudine);
    }

    @PostMapping("/{id}/add/poilogico")
    public void addPuntoLogico(@PathVariable Long id, String nome, String descrizione){
        comuneService.addPuntoLogico(id,nome,descrizione);
    }

    /*FUNZIONA SOLO SE LA RICHIESTA E' IN RAW JSON: BISOGNA COSTRUIRE UN ARRAY JSON PER MANDARLO*/
    @PostMapping("/{id}/provalogico")
    public void provaLogico(@PathVariable Long id, @RequestBody PuntoLogico puntoLogico){
        comuneService.aggiungiPOI(id,puntoLogico);
    }







}
