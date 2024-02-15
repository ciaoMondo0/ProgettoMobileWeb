package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.service.ContestService;
import com.it.unicam.progetto_ids_2023.service.SegnalazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contest")
public class ContestController {

    private ContestService contestService;


    @Autowired
    public ContestController(ContestService contestService){
        this.contestService = contestService;
    }


    @GetMapping("/")
    public List<Contest> getContest(/*@RequestParam Long id, @RequestParam Contenuto contenuto*/){
        return  contestService.getContests();
    }

    @PostMapping("add")
    public Contest addSegnalazione(@RequestParam String tematica, @RequestParam boolean pubblico){
        return contestService.creaContest(tematica, pubblico);
    }


    //Da sistemare
    @DeleteMapping("/{id}")
    public void deleteContest(@PathVariable Long id){
        contestService.deleteContest(id);
    }

    //Da completare e testare
}
