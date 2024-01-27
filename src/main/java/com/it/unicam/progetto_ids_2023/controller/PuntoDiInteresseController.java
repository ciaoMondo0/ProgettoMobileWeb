package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.service.PuntoDiInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pois")
public class PuntoDiInteresseController {
    private PuntoDiInteresseService puntoDiInteresseService;

    @Autowired
    public PuntoDiInteresseController(PuntoDiInteresseService puntoDiInteresseService){
        this.puntoDiInteresseService = puntoDiInteresseService;
    }

    /*@GetMapping("/all")
    public List<PuntoDiInteresse> getAllPuntiDiInteresse(){
        return puntoDiInteresseService.getAllPuntiDiInteresse();
    }*/
}
