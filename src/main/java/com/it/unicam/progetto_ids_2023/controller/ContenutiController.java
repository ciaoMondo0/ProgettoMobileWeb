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
import com.it.unicam.progetto_ids_2023.service.CommentService;
import com.it.unicam.progetto_ids_2023.service.ContenutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/contenuti")
public class ContenutiController {




    private ContenutiService contenutiService;

    private CommentService commentService;
    private ContenutoFactory contenutoFactory;


    @Autowired
    public ContenutiController(ContenutiService contenutiService, CommentService commentService){
        this.contenutiService = contenutiService;
        this.commentService = commentService;
    }


    @GetMapping("/")
    public List<Contenuto> getContenuto(/*@RequestParam Long id, @RequestParam Contenuto contenuto*/){
        return contenutiService.getContenuti();
    }


    @PostMapping("/add")
    public ResponseEntity<String> addContenuto(@RequestBody ContenutoDTO contenutoDTO, @RequestParam Long UtenteId, @RequestParam Long ComuneId) {

        {
            try {
                contenutiService.addContenuto(contenutoDTO, UtenteId, ComuneId);
                return ResponseEntity.ok("Contenuto added successfully");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Invalid parameters");
            }
        }
    }

    @PostMapping("/{contenutoId}/commenti/add")
    public ResponseEntity<String> addCommentToContenuto(@RequestParam Long utenteId,
                                                        @RequestParam String testo,
                                                        @PathVariable Long contenutoId) {
        commentService.addComment(contenutoId, utenteId, testo);
        return ResponseEntity.ok("Commento aggiunto al contenuto con successo");
    }


    @PutMapping("/contenuti/testuali/{testoId}/accetta")
    public void accettaContenuto(@PathVariable Long testoId) {
        contenutiService.accettaContenutoTestuale(testoId);
    }

    @DeleteMapping("/contenuti/testuali/{multiMediaid}/{testoId}")
    public void deleteContenuto(@PathVariable Long multiMediaid, @PathVariable Long testoId) {
        contenutiService.deleteContenutoTestuale(multiMediaid, testoId);
    }

    @PutMapping("/contenuti/testuali/{contenutoTestoId}/rifiuta")
    public void rifiutaContenutoTestuale(@PathVariable Long contenutoTestoId) {
        contenutiService.rifiutaContenutoTestuale(contenutoTestoId);
    }

    @GetMapping("/contenuti/per-nome")
    public List<Contenuto> trovaContenutiPerNome(@RequestParam String nome) {
        return contenutiService.trovaContenutiPerNome(nome);
    }

    @GetMapping("/contenuti/per-stato")
    public List<Contenuto> trovaContenutiPerStato(@RequestParam ContenutiStati stato) {
        return contenutiService.trovaContenutiPerStato(stato);
    }

    @GetMapping("/contenuti/per-intervallo")
    public List<Contenuto> trovaContenutiPerIntervallo(@RequestParam LocalDateTime start,
                                                       @RequestParam LocalDateTime end) {
        return contenutiService.trovaContenutiPerIntervallo(start, end);
    }



}
