package com.it.unicam.progetto_ids_2023.controller;


import com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.service.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private UtenteService utenteService;

    public UtenteController(UtenteService utenteService){
        this.utenteService = utenteService;
    }




    @PostMapping("/login")
    public ResponseEntity<Utente> login(@RequestParam String email, @RequestParam String password) {
        Utente utente = utenteService.login(email, password);
        if (utente != null) {
            return ResponseEntity.ok(utente);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/cancella")
    public ResponseEntity<String> cancellaUtente(@RequestParam Long utenteId) {
        utenteService.cancellaUtente(utenteId);
        return ResponseEntity.ok("Utente eliminato con successo");
    }

    @PostMapping("/assegna-ruolo")
    public ResponseEntity<String> assegnaRuolo(@RequestParam Long utenteId, @RequestParam Ruolo ruolo) {
        utenteService.assegnaRuolo(utenteId, ruolo);
        return ResponseEntity.ok("Ruolo assegnato con successo");
    }

    @PostMapping("/registra")
    public ResponseEntity<String> registraUtente(@RequestBody UtenteDTO utenteDTO){
        {
            try {
                utenteService.registrazione(utenteDTO);
                return ResponseEntity.ok("Utente aggiunto con successo");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Invalid parameters");
            }
        }
    }
    @PostMapping("/utenti/{utenteId}/preferiti/contenuti")
    public void aggiungiPreferitoContenuto(@PathVariable Long utenteId, @PathVariable Long contenutoId) {
        utenteService.aggiungiPreferitoContenuto(utenteId, contenutoId);
    }

    @DeleteMapping("/utenti/{utenteId}/preferiti/contenuti")
    public void rimuoviPreferitoContenuto(@PathVariable Long utenteId, @PathVariable Long contenutoId) {
        utenteService.rimuoviPreferitoContenuto(utenteId, contenutoId);
    }

    @PostMapping("/utenti/{utenteId}/preferiti/punti-di-interesse")
    public void aggiungiPreferitoPuntoDiInteresse(@PathVariable Long utenteId, @PathVariable Long puntoDiInteresseId) {
        utenteService.aggiungiPreferitoPuntoDiInteresse(utenteId, puntoDiInteresseId);
    }

    @DeleteMapping("/utenti/{utenteId}/preferiti/punti-di-interesse")
    public void rimuoviPreferitoPuntoDiInteresse(@PathVariable Long utenteId, @PathVariable Long puntoDiInteresseId) {
        utenteService.rimuoviPreferitoPuntoDiInteresse(utenteId, puntoDiInteresseId);
}
    @GetMapping("/getutenti")
    public List<Utente> getUtenti(){
        return utenteService.getAll();
}

}


