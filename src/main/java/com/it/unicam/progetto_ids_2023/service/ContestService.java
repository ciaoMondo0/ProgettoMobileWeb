package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.InvitoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.contenuto.Invito;
import com.it.unicam.progetto_ids_2023.model.factory.InvitoFactory;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {
    private final ContenutoMultimedialeRepository multiRepo;
    private final ContenutoBaseRepository testoRepo;
    private final ComuneRepository comuneRepo;

    private InvitoDTO invitoDTO;

    private InvitoFactory invitoFactory;

   private final InvitoRepository invitoRepository;
    /* private final PuntoDiInteresse punto; */
    private final ContestRepository contestRepo;


    //Classe da testare

    @Autowired
    public ContestService(ContenutoMultimedialeRepository multiRepo,
                          ContenutoBaseRepository testoRepo,
                          ComuneRepository comuneRepo,
                         /* PuntoDiInteresse punto, */
                          ContestRepository contestRepo, InvitoRepository invitoRepository,
                          InvitoFactory invitoFactory){
        this.multiRepo = multiRepo;
        this.testoRepo = testoRepo;
        this.comuneRepo = comuneRepo;
      /*  this.punto = punto; no beans of puntoDiInteresse type found, da sistemare*/
        this.contestRepo = contestRepo;
        this.invitoRepository = invitoRepository;
        this.invitoFactory = invitoFactory;
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

        contestRepo.deleteById(id);
    }


    public void sendInvito(InvitoDTO invitoDto) {
        invitoFactory.createInvito(invitoDto);

    }

    public void creaContenuto(String testo, Contest contest, Utente autore, List<Contenuto> contenuti) {
       boolean utenteAutorizzato = invitoRepository.existsByUtenteAndContest(autore, contest);
        if (!utenteAutorizzato) {
            throw new IllegalStateException("L'utente non è autorizzato a creare contenuti.");
        }


        if (contest.getClosed() && !autore.isContributorAutorizzato()) {
            throw new IllegalStateException("Impossibile pubblicare il contenuto: il contest è chiuso al pubblico e l'utente non è autorizzato.");
        } else {
            contest.setContenuti(contenuti);
            contestRepo.save(contest);
        }
    }

    public void setWinner(Long contestId, Utente vincitore) {
        Contest contest = contestRepo.findById(contestId)
                .orElseThrow(() -> new IllegalArgumentException("Contest not found with ID: " + contestId));

      //  contest.setVincitore(vincitore);

        contestRepo.save(contest);
    }




    public List<Contest> getContests(){
       return contestRepo.findAll();
    }






}

