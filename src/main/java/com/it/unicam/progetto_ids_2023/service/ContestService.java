package main.java.com.it.unicam.progetto_ids_2023.service;

import main.java.com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import main.java.com.it.unicam.progetto_ids_2023.dto.InvitoDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Invito;
import main.java.com.it.unicam.progetto_ids_2023.model.factory.ContenutoFactory;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import main.java.com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.ContestRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.InvitoRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ContestService {

    private final ComuneRepository comuneRepo;
    private final ContestRepository contestRepo;
    private final InvitoRepository invitoRepository;
    private final ContenutoFactory contenutoFactory;
    private final UtenteRepository utenteRepository;
    private final ContenutoRepository contenutoRepository;

    @Autowired
    public ContestService(ComuneRepository comuneRepo,
                          ContestRepository contestRepo,
                          InvitoRepository invitoRepository,
                          ContenutoFactory contenutoFactory,
                          UtenteRepository utenteRepository,
                          ContenutoRepository contenutoRepository) {
        this.comuneRepo = comuneRepo;
        this.contestRepo = contestRepo;
        this.invitoRepository = invitoRepository;
        this.contenutoFactory = contenutoFactory;
        this.utenteRepository = utenteRepository;
        this.contenutoRepository = contenutoRepository;
    }

    public Contest creaContest(String tematica, boolean closed, LocalDateTime inizio, LocalDateTime fine) {
        return contestRepo.save(new Contest(tematica, closed, inizio, fine));
    }

    public void closeContest(Long id) {
        Contest contest = contestRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Contest non trovato con id: " + id));
        contest.setClosed(true);
        contestRepo.save(contest);
    }

    public void deleteContest(Long id) {
        contestRepo.deleteById(id);
    }


    public Invito sendInvito(InvitoDTO invitoDto) {
        Invito invito = new Invito();
        List<Long> invitati = invitoDto.utentiId();
        List<Utente> utentiInvitati = new ArrayList<>();

        // Recupera il contest associato
        Contest contest = contestRepo.findById(invitoDto.contestId())
                .orElseThrow(() -> new NoSuchElementException("Contest non trovato " + invitoDto.contestId()));
        invito.setContest(contest);

        // Recupera gli utenti invitati
        for (Long utenteId : invitati) {
            Utente utente = utenteRepository.findById(utenteId)
                    .orElseThrow(() -> new NoSuchElementException("Utente non trovato " + utenteId));
            utentiInvitati.add(utente);
        }
        invito.setUtente(utentiInvitati);
        invito.setContenuto(invitoDto.invito());

        invitoRepository.save(invito);
        return invito;
    }

    public void creaContenuto(Long contestId, Long autoreId, ContenutoDTO contenutoDTO) {
        Contest contest = contestRepo.findById(contestId)
                .orElseThrow(() -> new NoSuchElementException("Contest non trovato con id: " + contestId));

        Utente autore;
        if (contest.getClosed()) {
            autore = invitoRepository.findByUtenteId(autoreId)
                    .orElseThrow(() -> new NoSuchElementException("Utente non trovato tramite invito con id: " + autoreId));
        } else {
            autore = utenteRepository.findById(autoreId)
                    .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + autoreId));
        }

        Contenuto contenuto = contenutoFactory.createContenuto(contenutoDTO);
        contenuto.setUtente(autore);
        contenutoRepository.save(contenuto);

        contest.setContenutoBase(contenuto);
        contestRepo.save(contest);
    }

    public void setWinner(Long contestId, Long utenteId) {
        Contest contest = contestRepo.findById(contestId)
                .orElseThrow(() -> new IllegalArgumentException("Contest non trovato con ID: " + contestId));
        Utente vincitore = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new NoSuchElementException("Utente non trovato con id: " + utenteId));

        contest.setUtente(vincitore);
        contestRepo.save(contest);
    }

    public List<Contest> getContests() {
        return contestRepo.findAll();
    }
}
