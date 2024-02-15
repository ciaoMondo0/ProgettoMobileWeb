package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.service.ContenutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contenuti")
public class ContenutiController {



        private ContenutiService contenutiService;


        @Autowired
        public ContenutiController(ContenutiService contenutiService){
            this.contenutiService = contenutiService;
        }


        @GetMapping("/")
        public List<Contenuto> getContenuto(/*@RequestParam Long id, @RequestParam Contenuto contenuto*/){
            return null;
        }


}
