package com.it.unicam.progetto_ids_2023.controller;


import com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.service.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PostMapping("/registra")
    public ResponseEntity<String> registraUtente(@RequestBody UtenteDTO utenteDTO) {
        {
            try {
                utenteService.registrazione(utenteDTO);
                return ResponseEntity.ok("Utente aggiunto con successo");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Invalid parameters");
            }
        }
    }

    @GetMapping("/getutenti")
    public List<Utente> getUtenti() {
        return utenteService.getAll();

    }
}



