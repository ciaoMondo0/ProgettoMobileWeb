package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import com.it.unicam.progetto_ids_2023.dto.ContenutoBaseDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoMultimedialeRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ContentFactory implements ContenutoFactory {

    private final ContenutoBaseRepository testoRepo;
    private final ContenutoMultimedialeRepository multiRepo;
    private final ComuneRepository comuneRepo;

    @Autowired
    public ContentFactory(ContenutoBaseRepository testoRepo, ContenutoMultimedialeRepository multiRepo, ComuneRepository comuneRepo) {
        this.testoRepo = testoRepo;
        this.multiRepo = multiRepo;
        this.comuneRepo = comuneRepo;
    }
    @Override
    public ContenutoBase createContenuto(ContenutoBaseDTO contenutoDTO) {
      //  Long id = contenutoDTO.id();
       // Utente utente = contenutoDTO.utente();
        String testo = contenutoDTO.testo();
        boolean pending = contenutoDTO.pending();
        ContenutiStati stati = contenutoDTO.stati();

        // Create ContenutoBase instance using the constructor with additional parameters
        return new ContenutoBase(testo, pending, stati);


    }


}
