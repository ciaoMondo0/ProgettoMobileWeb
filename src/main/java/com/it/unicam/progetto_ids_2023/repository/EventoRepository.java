package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Long> {
}
