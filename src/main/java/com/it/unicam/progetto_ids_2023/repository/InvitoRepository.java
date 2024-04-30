package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.contenuto.Invito;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvitoRepository extends JpaRepository<Invito, Long> {
  Optional<Utente> findByUtenteId(Long id);


}
