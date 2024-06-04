package main.java.com.it.unicam.progetto_ids_2023.model.factory;

import main.java.com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import main.java.com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteFactory {

    private final UtenteRepository utenteRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


@Autowired
    public UtenteFactory(UtenteRepository utenteRepository, BCryptPasswordEncoder passwordEncoder){
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Utente createUtente(UtenteDTO utenteDTO){
        Utente utente = new Utente();
        Ruolo ruolo = Ruolo.TURISTA_AUTENTICATO;
        String username = utenteDTO.username();
        String email = utenteDTO.email();
        utente.setRuolo(ruolo);
        utente.setEmail(email);
        utente.setNome(username);
        String encodedPassword = passwordEncoder.encode(utenteDTO.password());

        utente.setPassword(encodedPassword);
        return utente;
    }
}

