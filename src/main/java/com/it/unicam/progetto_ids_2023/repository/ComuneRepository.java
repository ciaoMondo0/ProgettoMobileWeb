package main.java.com.it.unicam.progetto_ids_2023.repository;

import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuneRepository extends JpaRepository<Comune,Long> {
}
