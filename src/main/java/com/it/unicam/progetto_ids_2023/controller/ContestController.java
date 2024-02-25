package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.dto.InvitoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.service.ContestService;
import com.it.unicam.progetto_ids_2023.service.SegnalazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contest")
public class ContestController {

    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

  /*  @PostMapping
    public ResponseEntity<Contest> createContest(@RequestParam String tematica, @RequestParam boolean pubblico) {
        Contest contest = contestService.creaContest(tematica, pubblico);
        return new ResponseEntity<>(contest, HttpStatus.CREATED);
    }*/

    @PutMapping("/{id}/close")
    public ResponseEntity<Void> closeContest(@PathVariable Long id) {
        contestService.closeContest(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContest(@PathVariable Long id) {
        contestService.deleteContest(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/send-invite")
    public ResponseEntity<Void> sendInvitation(@PathVariable Long id, @RequestBody InvitoDTO invitoDTO) {
        contestService.sendInvito(invitoDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/create-content")
    public ResponseEntity<Void> createContent(@PathVariable Long id, @RequestParam String testo/*, @RequestBody Utente autore*/, @RequestBody List<Contenuto> contenuti) {
        // You need to implement this method in ContestService
       // contestService.creaContenuto(testo, id, autore, contenuti);
        return ResponseEntity.ok().build();
    }

   /* @PutMapping("/{id}/set-winner")
    public ResponseEntity<Void> setVincitore(@PathVariable Long id//, @RequestBody //Utente vincitore) {
       // contestService.setVincitore(id, winner);
        return ResponseEntity.ok().build();
    }*/

    @GetMapping
    public ResponseEntity<List<Contest>> getAllContests() {
        List<Contest> contests = contestService.getContests();
        return ResponseEntity.ok(contests);
    }
}
