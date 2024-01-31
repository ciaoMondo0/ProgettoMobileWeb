package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContestService {
    private final ContenutoMultimedialeRepository multiRepo;
    private final ContenutoTestualeRepository testoRepo;
    private final ComuneRepository comuneRepo;
    /* private final PuntoDiInteresse punto; */
    private final ContestRepository contestRepo;


    //Classe da testare

    @Autowired
    public ContestService(ContenutoMultimedialeRepository multiRepo,
                          ContenutoTestualeRepository testoRepo,
                          ComuneRepository comuneRepo,
                         /* PuntoDiInteresse punto, */
                          ContestRepository contestRepo){
        this.multiRepo = multiRepo;
        this.testoRepo = testoRepo;
        this.comuneRepo = comuneRepo;
      /*  this.punto = punto; no beans of puntoDiInteresse type found, da sistemare*/
        this.contestRepo = contestRepo;
    }

    public Contest creaContest(String tematica, boolean pubblico){
        return contestRepo.save(new Contest(tematica, pubblico));
    }

    public void closeContest(Long id){
        Contest contest = contestRepo.findById(id).orElseThrow();
        contest.setClosed(true);
        contestRepo.save(contest);
    }



    public void deleteContest(Long id){
        Contest contest = contestRepo.findById(id).orElseThrow();
        contestRepo.delete(contest);
    }






}

