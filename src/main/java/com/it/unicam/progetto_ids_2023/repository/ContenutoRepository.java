package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.contenuto.IContenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ContenutoRepository  extends JpaRepository<Contenuto,Long> {

    List<Contenuto> findByStati(ContenutiStati stato);


    List<Contenuto> findByNomeContainingIgnoreCase(String nome);

    List<Contenuto> findAllByPending(ContenutiStati stati);

    List<Contenuto> findAllByDateBetween(LocalDateTime start, LocalDateTime end);


}
