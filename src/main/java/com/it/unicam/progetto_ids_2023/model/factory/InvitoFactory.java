package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.InvitoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.contenuto.Invito;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.ContestRepository;
import com.it.unicam.progetto_ids_2023.repository.InvitoRepository;
import com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InvitoFactory {
    private final UtenteRepository utenteRepository;
    private final InvitoRepository invitoRepository;

    private final ContestRepository contestRepository;


    public InvitoFactory(UtenteRepository utenteRepository, InvitoRepository invitoRepository, ContestRepository contestRepository){
        this.utenteRepository = utenteRepository;
        this.invitoRepository = invitoRepository;
        this.contestRepository = contestRepository;
    }

    public Invito createInvito(InvitoDTO invitoDTO){
        Invito invito = new Invito();
        List<Long> invitati = invitoDTO.utentiId();
        List<Utente> utentiInvitati = new ArrayList<>();
        Contest contest = contestRepository.findById(invitoDTO.contestId()).orElseThrow(() -> new NoSuchElementException("Contest non trovato " + invitoDTO.contestId()));
        invito.setContest(contest);



        for (Long utenteId : invitati) {

            Optional<Utente> optionalUtente = utenteRepository.findById(utenteId);
            optionalUtente.ifPresent(utentiInvitati::add);
        }



        invito.setUtente(utentiInvitati);
        invito.setContenuto(invitoDTO.invito());
        invitoRepository.save(invito);
        return invito;

    }
}
