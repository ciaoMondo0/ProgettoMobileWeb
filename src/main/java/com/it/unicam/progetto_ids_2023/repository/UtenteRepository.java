package main.java.com.it.unicam.progetto_ids_2023.repository;

import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository  extends JpaRepository<Utente, Long> {
    Utente findByEmail (String email);
}
