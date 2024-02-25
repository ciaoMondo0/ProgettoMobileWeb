package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.dto.ContenutoBaseDTO;
import com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.factory.ContenutoFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.service.ContenutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenuti")
public class ContenutiController {



        private ContenutiService contenutiService;
        private ContenutoFactory contenutoFactory;


        @Autowired
        public ContenutiController(ContenutiService contenutiService){
            this.contenutiService = contenutiService;
        }


        @GetMapping("/")
        public List<ContenutoBase> getContenuto(/*@RequestParam Long id, @RequestParam Contenuto contenuto*/){
            return contenutiService.getContenuti();
        }


    @PostMapping("/add")
    public ResponseEntity<String> addContenuto(@RequestBody ContenutoBaseDTO contenutoDTO) {

        {
            try {
                contenutiService.addContenuto(contenutoDTO);
                return ResponseEntity.ok("Contenuto added successfully");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Invalid parameters");
            }
        }
    }


}
