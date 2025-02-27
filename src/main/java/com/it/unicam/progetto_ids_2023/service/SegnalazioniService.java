package main.java.com.it.unicam.progetto_ids_2023.service;

import main.java.com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.StatoSegnalazioni;
import main.java.com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.SegnalazioniRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegnalazioniService {

    private final ContenutoRepository contenutoRepository;
    private final ComuneRepository comuneRepo;
    private final SegnalazioniRepository segnalazioneRepo;
    private final UtenteRepository utenteRepository;

    @Autowired
    public SegnalazioniService(ContenutoRepository contenutoRepository,
                               ComuneRepository comuneRepo,
                               SegnalazioniRepository segnalazioneRepo,
                               UtenteRepository utenteRepository) {
        this.contenutoRepository = contenutoRepository;
        this.comuneRepo = comuneRepo;
        this.segnalazioneRepo = segnalazioneRepo;
        this.utenteRepository = utenteRepository;
    }

    public List<Segnalazione> getSegnalazioni() {
        return segnalazioneRepo.findAll();
    }

    public Segnalazione aggiungiSegnalazione(SegnalazioniDTO segnalazioniDTO) {
        // Recupera il contenuto utilizzando il ContenutoRepository
        Contenuto contenuto = contenutoRepository.findById(segnalazioniDTO.ContenutoId())
                .orElseThrow(() -> new IllegalArgumentException("Contenuto non trovato con id: " + segnalazioniDTO.ContenutoId()));
        // Crea una nuova segnalazione con stato PENDING
        Segnalazione segnalazione = new Segnalazione(contenuto, segnalazioniDTO.testoSegnalazione(), StatoSegnalazioni.PENDING);
        return segnalazioneRepo.save(segnalazione);
    }

    @Transactional
    public void eliminaSegnalazione(Long id) {
        Segnalazione segnalazione = segnalazioneRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Segnalazione non trovata con id: " + id));
        if (segnalazione.getStatoSegnalazioni().equals(StatoSegnalazioni.ACCETTATO)) {
            Long contentId = segnalazione.getContentId();
            Contenuto contenuto = contenutoRepository.findById(contentId)
                    .orElseThrow(() -> new IllegalArgumentException("Contenuto non trovato con id: " + contentId));
            contenutoRepository.delete(contenuto);
            segnalazioneRepo.deleteById(id);
        } else if (segnalazione.getStatoSegnalazioni().equals(StatoSegnalazioni.RIFIUTATO)) {
            segnalazioneRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Impossibile eliminare la segnalazione in stato: " + segnalazione.getStatoSegnalazioni());
        }
    }

    public void accettaSegnalazione(Long segnalazioneId) {
        Segnalazione segnalazione = segnalazioneRepo.findById(segnalazioneId)
                .orElseThrow(() -> new IllegalArgumentException("Segnalazione non trovata con id: " + segnalazioneId));
        segnalazione.setStatoSegnalazioni(StatoSegnalazioni.ACCETTATO);
        segnalazioneRepo.save(segnalazione);
    }

    public Segnalazione getSegnalazione(Long id, Contenuto contenuto) {
        Segnalazione segnalazione = segnalazioneRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Segnalazione non trovata con id: " + id));
        if (segnalazione.getContenuto().equals(contenuto)) {
            return segnalazione;
        }
        return null;
    }

    public void rifiutaSegnalazione(Long segnalazioneId) {
        Segnalazione segnalazione = segnalazioneRepo.findById(segnalazioneId)
                .orElseThrow(() -> new IllegalArgumentException("Segnalazione non trovata con id: " + segnalazioneId));
        segnalazione.setStatoSegnalazioni(StatoSegnalazioni.RIFIUTATO);
        segnalazioneRepo.save(segnalazione);
    }
}

