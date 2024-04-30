package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.ContenutoBaseDTO;
import com.it.unicam.progetto_ids_2023.dto.InvitoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.contenuto.Invito;
import com.it.unicam.progetto_ids_2023.model.factory.ContenutoFactory;
import com.it.unicam.progetto_ids_2023.model.factory.InvitoFactory;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContestService {
    private final ContenutoMultimedialeRepository multiRepo;
    private final ContenutoBaseRepository testoRepo;
    private final ComuneRepository comuneRepo;

    private InvitoDTO invitoDTO;

    private InvitoFactory invitoFactory;
    private ContenutoFactory contenutoFactory;

   private final InvitoRepository invitoRepository;
    /* private final PuntoDiInteresse punto; */
    private final ContestRepository contestRepo;

    private UtenteRepository utenteRepository;


    //Classe da testare

    @Autowired
    public ContestService(ContenutoMultimedialeRepository multiRepo,
                          ContenutoBaseRepository testoRepo,
                          ComuneRepository comuneRepo,
                         /* PuntoDiInteresse punto, */
                          ContestRepository contestRepo, InvitoRepository invitoRepository,
                          InvitoFactory invitoFactory,
                          ContenutoFactory contenutoFactory,
                          UtenteRepository utenteRepository){
        this.multiRepo = multiRepo;
        this.testoRepo = testoRepo;
        this.comuneRepo = comuneRepo;
      /*  this.punto = punto; no beans of puntoDiInteresse type found, da sistemare*/
        this.contestRepo = contestRepo;
        this.invitoRepository = invitoRepository;
        this.invitoFactory = invitoFactory;
        this.contenutoFactory = contenutoFactory;
        this.utenteRepository = utenteRepository;
    }

    public Contest creaContest(String tematica, boolean pubblico, LocalDateTime inizio, LocalDateTime fine){
        return contestRepo.save(new Contest(tematica, pubblico, inizio, fine));
    }

    public void closeContest(Long id){
        Contest contest = contestRepo.findById(id).orElseThrow();
        contest.setClosed(true);
        contestRepo.save(contest);
    }

    public void deleteContest(Long id){

        contestRepo.deleteById(id);
    }


    public void sendInvito(InvitoDTO invitoDto) {
        invitoFactory.createInvito(invitoDto);

    }

    public void creaContenuto(Long contestId, Long autoreId, ContenutoBaseDTO contenutoBaseDTO) {
        Contest contest = contestRepo.findById(contestId).orElseThrow();
        if(contest.getClosed()){
            Utente autore = invitoRepository.findByUtenteId(autoreId).orElseThrow();
            ContenutoBase contenuto =  contenutoFactory.createContenuto(contenutoBaseDTO);
            contenuto.setUtente(autore);

            contest.setContenutoBase(contenuto);
            contestRepo.save(contest);

        } else {
       Utente autore = utenteRepository.findById(autoreId).orElseThrow();
        ContenutoBase contenuto =  contenutoFactory.createContenuto(contenutoBaseDTO);
        contenuto.setUtente(autore);
        contest.setContenutoBase(contenuto);
       contestRepo.save(contest);

        }


    }

    public void setWinner(Long contestId, Utente vincitore) {
        Contest contest = contestRepo.findById(contestId)
                .orElseThrow(() -> new IllegalArgumentException("Contest not found with ID: " + contestId));


      contest.setUtente(vincitore);

        contestRepo.save(contest);
    }




    public List<Contest> getContests(){
       return contestRepo.findAll();
    }






}

