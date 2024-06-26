package main.java.com.it.unicam.progetto_ids_2023.repository;

import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoLogico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PuntoDiInteresseRepository extends JpaRepository<PuntoDiInteresse,Long> {
    List<PuntoDiInteresse> findByNomeContainingIgnoreCase(String nome);

}