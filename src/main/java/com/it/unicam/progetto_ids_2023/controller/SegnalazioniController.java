package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.service.SegnalazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segnalazioni")
public class SegnalazioniController {

    private SegnalazioniService segnalazioniService;




    @Autowired
    public SegnalazioniController(SegnalazioniService segnalazioniService){
        this.segnalazioniService = segnalazioniService;
    }


    @GetMapping("/")
    public List<Segnalazione> getSegnalazione(/*@RequestParam Long id, @RequestParam Contenuto contenuto*/){
        return  segnalazioniService.getSegnalazioni();
    }

    @PostMapping("/add")
    public Segnalazione addSegnalazione(@RequestBody SegnalazioniDTO segnaDto){
        return segnalazioniService.aggiungiSegnalazione(segnaDto);
    }


    //Da sistemare
    @DeleteMapping("/delete/{id}")
    public void deleteSegnalazione(@PathVariable Long id){
        segnalazioniService.eliminaSegnalazione(id);
    }



    //Da sistemare
    @PatchMapping("/rifiuta/{id}")
    public void rifiutaSegnalazione(@PathVariable  Long id){
        segnalazioniService.rifiutaSegnalazione(id);
    }

    @PatchMapping("/accetta/{id}")
    public void accettaSegnalazione(@PathVariable  Long id){
        segnalazioniService.accettaSegnalazione(id);
    }




}