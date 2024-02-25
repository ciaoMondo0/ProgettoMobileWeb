package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoLogico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuntoFisicoRepository extends JpaRepository<PuntoFisico,Long> {
    List<PuntoFisico> findByNomeContainingIgnoreCase(String searchString);

}
