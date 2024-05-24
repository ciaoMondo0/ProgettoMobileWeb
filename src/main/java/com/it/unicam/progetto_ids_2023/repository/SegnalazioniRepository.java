package main.java.com.it.unicam.progetto_ids_2023.repository;

import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SegnalazioniRepository extends JpaRepository<Segnalazione, Long> {
    List<Segnalazione> findByContenuto(Contenuto contenuto);


}