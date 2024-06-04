package main.java.com.it.unicam.progetto_ids_2023.controller;

import main.java.com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.factory.ContenutoFactory;
import main.java.com.it.unicam.progetto_ids_2023.service.CommentService;
import main.java.com.it.unicam.progetto_ids_2023.service.ContenutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/contenuti")
public class ContenutiController {




    private ContenutiService contenutiService;

    private CommentService commentService;
    private ContenutoFactory contenutoFactory;
    private static final Logger logger = LoggerFactory.getLogger(ContenutiController.class);



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
    public ResponseEntity<String> addContenuto(@RequestBody ContenutoDTO contenutoDTO) {

            contenutiService.addContenuto(contenutoDTO);

            return ResponseEntity.ok("Contenuto aggiunto con successo");

    }

    @PostMapping("/{contenutoId}/commenti/add")
    public ResponseEntity<String> addCommentToContenuto(@RequestParam Long utenteId,
                                                        @RequestParam String testo,
                                                        @PathVariable Long contenutoId) {
        commentService.addComment(contenutoId, utenteId, testo);
        return ResponseEntity.ok("Commento aggiunto al contenuto con successo");
    }


    @PutMapping("/contenuti/{contenutoId}/accetta")
    public void accettaContenuto(@PathVariable Long contenutoId) {
        contenutiService.accettaContenuto(contenutoId);
    }

    @DeleteMapping("/contenuti/{contenutoId}")
    public void deleteContenuto( @PathVariable Long contenutoId) {
        contenutiService.deleteContenuto(contenutoId);
    }

    @PutMapping("/contenuti/{contenutoId}/rifiuta")
    public void rifiutaContenuto(@PathVariable Long contenutoId) {
        contenutiService.rifiutaContenuto(contenutoId);
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
