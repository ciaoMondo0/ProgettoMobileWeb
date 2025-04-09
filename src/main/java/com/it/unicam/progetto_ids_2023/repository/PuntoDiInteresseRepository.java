package main.java.com.it.unicam.progetto_ids_2023.repository;

import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuntoDiInteresseRepository extends JpaRepository<PuntoDiInteresse,Long> {
    List<PuntoDiInteresse> findByNomeContainingIgnoreCase(String nome);

}