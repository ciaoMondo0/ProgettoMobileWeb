package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.dto.InvitoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.service.ContestService;
import com.it.unicam.progetto_ids_2023.service.SegnalazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/contest")
public class ContestController {

    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }



    @PostMapping("/add/contest")
    public Contest addContest(@RequestParam String tematica, @RequestParam boolean pubblico, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime inizio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fine){
        return contestService.creaContest(tematica, pubblico, inizio, fine);
    }

    @PutMapping("/{id}/close")
    public void closeContest(@PathVariable Long id) {
        contestService.closeContest(id);

    }

    @DeleteMapping("/{id}")
    public void deleteContest(@PathVariable Long id) {
        contestService.deleteContest(id);

    }

    @PostMapping("/{id}/send-invite")
    public ResponseEntity<String> sendInvitation(@RequestBody InvitoDTO invitoDTO) {
        contestService.sendInvito(invitoDTO);
        return ResponseEntity.ok("Invito mandato con successo");
    }

    @PostMapping("/{id}/create-content")
    public ResponseEntity<Void> createContent(@PathVariable Long id, @RequestParam String testo/*, @RequestBody Utente autore*/, @RequestBody List<Contenuto> contenuti) {
       // contestService.creaContenuto(testo, id, autore, contenuti);
        return ResponseEntity.ok().build();
    }

   /* @PutMapping("/{id}/set-winner")
    public ResponseEntity<Void> setWinner(@PathVariable Long id//, @RequestBody //Utente winner) {
       // contestService.setWinner(id, winner);
        return ResponseEntity.ok().build();
    }*/

    @GetMapping
    public ResponseEntity<List<Contest>> getAllContests() {
        List<Contest> contests = contestService.getContests();
        return ResponseEntity.ok(contests);
    }
}
