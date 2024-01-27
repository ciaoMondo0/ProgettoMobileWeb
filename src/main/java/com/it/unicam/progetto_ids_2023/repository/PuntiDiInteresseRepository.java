package com.it.unicam.progetto_ids_2023.repository;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PuntiDiInteresseRepository extends JpaRepository<PuntoDiInteresse,Long> {

    /*@Query(value = "select * from comune", nativeQuery = true)
    List<Comune> getComuni();*/

    /*@Query(value = "select c.contenuti from comune where c.id=:id", nativeQuery = true)
    List<Contenuto> getContenutiComune(@Param("id") Long id);*/
}
