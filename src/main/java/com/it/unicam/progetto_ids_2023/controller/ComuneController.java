package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.*;
import com.it.unicam.progetto_ids_2023.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comuni")
public class ComuneController {
    private ComuneService comuneService;

    @Autowired
    public ComuneController(ComuneService comuneService) {
        this.comuneService = comuneService;
    }


    /*POPOLA IL DB*/
    @GetMapping("/popola")
    public void popola(){
        comuneService.popolaRepository();
    }




    /*COMUNI*/
    @GetMapping("/")
    public List<Comune> getComuni(){
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


    @PostMapping("/{id}/add/contenuto")
    public void addContenutoGenerico(@PathVariable Long id, @RequestBody Contenuto contenuto){
        comuneService.addContenutoComune(id,contenuto);
    }




    /*PUNTI DI INTERESSE*/
    @PostMapping("/{id}/add/poi")
    public void addPOI(@PathVariable Long id, @RequestBody PuntoDiInteresse puntoDiInteresse){
        comuneService.addPOI(id,puntoDiInteresse);
    }

    @GetMapping("/{id}/pois")
    public List<PuntoDiInteresse> getPOIS(@PathVariable Long id){
        return comuneService.getPOIS(id);
    }

    @GetMapping("/{idComune}/pois/{idPOI}/contenuti")
    public List<Contenuto> getContenutiPOI(@PathVariable Long idComune, @PathVariable Long idPOI){
        return comuneService.getContenutiPOI(idComune,idPOI);
    }

    @PostMapping("/{idComune}/pois/{idPOI}/addcontenuto")
    public void addContenutoPOI(@PathVariable Long idComune, @PathVariable Long idPOI, @RequestBody Contenuto contenuto){
        comuneService.addContenutoPOI(idComune,idPOI,contenuto);
    }


    /*ITINERARIO*/
    @GetMapping("/{idComune}/itinerari")
    public List<Itinerario> getItinerari(@PathVariable Long idComune){
        return comuneService.getItinerari(idComune);
    }

    @GetMapping("/{idComune}/itinerari/{idItinerario}/puntifisici")
    public List<PuntoFisico> getPuntiFisiciItinerario(@PathVariable Long idComune, @PathVariable Long idItinerario){
        return comuneService.getPuntiFisiciItinerario(idComune,idItinerario);
    }
    



    /*VECCHI METODI*/
    //    @PostMapping("/{id}/add/poifisico")
//    public void addPuntoFisico(@PathVariable Long id, String nome, String descrizione, double latitudine, double longitudine){
//        comuneService.addPuntoFisico(id,nome,descrizione,latitudine,longitudine);
//    }
//
//    @PostMapping("/{id}/add/poilogico")
//    public void addPuntoLogico(@PathVariable Long id, String nome, String descrizione){
//        comuneService.addPuntoLogico(id,nome,descrizione);
//    }

    /*FUNZIONA SOLO SE LA RICHIESTA E' IN RAW JSON: BISOGNA COSTRUIRE UN ARRAY JSON PER MANDARLO*/
//    @PostMapping("/{id}/provalogico")
//    public void provaLogico(@PathVariable Long id, @RequestBody PuntoLogico puntoLogico){
//        comuneService.aggiungiPOI(id,puntoLogico);
//    }

//
//    @PostMapping("/{id}/add/testo")
//    public void addContenutoComune(@PathVariable Long id, @RequestParam String testo, @RequestParam boolean pending){
//        comuneService.addTestoComune(id,testo,pending);
//    }






}
