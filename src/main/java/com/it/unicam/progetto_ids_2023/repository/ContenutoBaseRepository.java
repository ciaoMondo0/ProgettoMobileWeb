package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenutoBaseRepository extends JpaRepository<ContenutoBase,Long> {
   // List<ContenutoBase> findByNomeContainingIgnoreCase(String searchString);
}
