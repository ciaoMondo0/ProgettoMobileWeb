package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.utente.TuristaAutenticato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuristaAutenticatoRepository extends JpaRepository<TuristaAutenticato, Long> {
}
