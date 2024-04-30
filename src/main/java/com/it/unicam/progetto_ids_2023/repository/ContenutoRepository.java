package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenutoRepository  extends JpaRepository<Contenuto,Long> {
    List<Contenuto> findByNomeContainingIgnoreCase(String nome);
}
