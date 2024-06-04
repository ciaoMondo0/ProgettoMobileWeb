package main.java.com.it.unicam.progetto_ids_2023.controller;

import main.java.com.it.unicam.progetto_ids_2023.JWTSecurity.AuthenticationResponse;
import main.java.com.it.unicam.progetto_ids_2023.JWTSecurity.JwtTokenUtil;
import main.java.com.it.unicam.progetto_ids_2023.dto.LoginDTO;
import main.java.com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import main.java.com.it.unicam.progetto_ids_2023.service.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private UtenteService utenteService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public UtenteController(UtenteService utenteService){
        this.utenteService = utenteService;
    }



    @PostMapping("/login")

    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDTO loginDTO) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.email());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
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
    @PostMapping("/utenti/{utenteId}/{contenutoId}/preferiti/contenuti")
    public void aggiungiPreferitoContenuto(@PathVariable Long utenteId, @PathVariable Long contenutoId) {
        utenteService.aggiungiPreferitoContenuto(utenteId, contenutoId);
    }

    @DeleteMapping("/utenti/{utenteId}/{contenutoId}/preferiti/contenuti")
    public void rimuoviPreferitoContenuto(@PathVariable Long utenteId, @PathVariable Long contenutoId) {
        utenteService.rimuoviPreferitoContenuto(utenteId, contenutoId);
    }

    @PostMapping("/utenti/{utenteId}/{puntoDiInteresseId}/preferiti/punti-di-interesse")
    public void aggiungiPreferitoPuntoDiInteresse(@PathVariable Long utenteId, @PathVariable Long puntoDiInteresseId) {
        utenteService.aggiungiPreferitoPuntoDiInteresse(utenteId, puntoDiInteresseId);
    }

    @DeleteMapping("/utenti/{utenteId}/{puntoDiInteresseId}/preferiti/punti-di-interesse")
    public void rimuoviPreferitoPuntoDiInteresse(@PathVariable Long utenteId, @PathVariable Long puntoDiInteresseId) {
        utenteService.rimuoviPreferitoPuntoDiInteresse(utenteId, puntoDiInteresseId);
}
    @GetMapping("/getutenti")
    public List<Utente> getUtenti(){
        return utenteService.getAll();
}

}


