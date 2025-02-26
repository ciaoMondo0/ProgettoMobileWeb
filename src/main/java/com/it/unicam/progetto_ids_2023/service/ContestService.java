package main.java.com.it.unicam.progetto_ids_2023.service;

import main.java.com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import main.java.com.it.unicam.progetto_ids_2023.dto.InvitoDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.*;
import main.java.com.it.unicam.progetto_ids_2023.model.factory.ContenutoFactory;
import main.java.com.it.unicam.progetto_ids_2023.model.factory.InvitoFactory;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import main.java.com.it.unicam.progetto_ids_2023.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContestService {
    private final ContenutoMultimedialeRepository multiRepo;
    private final ContenutoTestualeRepository testoRepo;
    private final ComuneRepository comuneRepo;

    private InvitoDTO invitoDTO;

    private InvitoFactory invitoFactory;
    private ContenutoFactory contenutoFactory;

    private final InvitoRepository invitoRepository;
    private final ContestRepository contestRepo;

    private UtenteRepository utenteRepository;

    private ContenutoRepository contenutoRepository;



    @Autowired
    public ContestService(ContenutoMultimedialeRepository multiRepo,
                          ContenutoTestualeRepository testoRepo,
                          ComuneRepository comuneRepo,
                          ContestRepository contestRepo, InvitoRepository invitoRepository,
                          InvitoFactory invitoFactory,
                          ContenutoFactory contenutoFactory,
                          UtenteRepository utenteRepository,
                          ContenutoRepository contenutoRepository){
        this.multiRepo = multiRepo;
        this.testoRepo = testoRepo;
        this.comuneRepo = comuneRepo;
        this.contestRepo = contestRepo;
        this.invitoRepository = invitoRepository;
        this.invitoFactory = invitoFactory;
        this.contenutoFactory = contenutoFactory;
        this.utenteRepository = utenteRepository;
        this.contenutoRepository = contenutoRepository;
    }

    public Contest creaContest(String tematica, boolean closed, LocalDateTime inizio, LocalDateTime fine){
        return contestRepo.save(new Contest(tematica, closed, inizio, fine));
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

    public void creaContenuto(Long contestId, Long autoreId, ContenutoDTO contenutoDTO) {
        Contest contest = contestRepo.findById(contestId).orElseThrow();
        if(contest.getClosed()){
            Utente autore = invitoRepository.findByUtenteId(autoreId).orElseThrow();
            Contenuto contenuto =  contenutoFactory.createContenuto(contenutoDTO);
            contenuto.setUtente(autore);
            contenutoRepository.save(contenuto);

            contest.setContenutoBase(contenuto);
            contestRepo.save(contest);

        } else {
            Utente autore = utenteRepository.findById(autoreId).orElseThrow();
            Contenuto contenuto =  contenutoFactory.createContenuto(contenutoDTO);
            contenuto.setUtente(autore);
            contest.setContenutoBase(contenuto);
            contestRepo.save(contest);

        }


    }

    public void setWinner(Long contestId, Long  utenteId) {
        Contest contest = contestRepo.findById(contestId)
                .orElseThrow(() -> new IllegalArgumentException("Contest not found with ID: " + contestId));
        Utente vincitore = utenteRepository.findById(utenteId).orElseThrow();


        contest.setUtente(vincitore);

        contestRepo.save(contest);
    }




    public List<Contest> getContests(){
        return contestRepo.findAll();
    }






}

