package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenutoTestualeRepository extends JpaRepository<ContenutoTestuale,Long> {
   // List<ContenutoBase> findByNomeContainingIgnoreCase(String searchString);
}
