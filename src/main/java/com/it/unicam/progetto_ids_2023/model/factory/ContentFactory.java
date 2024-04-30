package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import com.it.unicam.progetto_ids_2023.dto.ContenutoBaseDTO;
import com.it.unicam.progetto_ids_2023.dto.ContenutoMultimedialeDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutiStati;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
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

        String testo = contenutoDTO.testo();
        boolean pending = contenutoDTO.pending();
        ContenutiStati stati = contenutoDTO.stati();

        return new ContenutoBase(testo, pending, stati);

        /*
        String testo = contenutoDTO.testo();
        boolean pending = contenutoDTO.pending();
        ContenutiStati stati = contenutoDTO.stati();

        return new ContenutoBase(testo, pending, stati);

        ContenutoTipo tipoContenuto = contenutoDTO.tipo(); // Assumendo che il DTO includa il tipo di contenuto
        if ("TESTUALE".equals(tipoContenuto)) {
            return new ContenutoBase(contenutoDTO.testo(), contenutoDTO.pending(), contenutoDTO.stati());
        } else if ("MULTIMEDIALE".equals(tipoContenuto)) {
            return new ContenutoMultimediale(contenutoDTO.file(), contenutoDTO.pending());
        } else {
            throw new IllegalArgumentException("Tipo di contenuto non supportato");
        }

*/


    }

    public ContenutoMultimediale createContenutoMultimediale(ContenutoMultimedialeDTO contenutoMultimedialeDTO){
        String file = contenutoMultimedialeDTO.file();
        boolean pending = contenutoMultimedialeDTO.pending();
        return new ContenutoMultimediale(file, pending);
    }


    public ContenutoBase createContenutoContest(ContenutoBaseDTO contenutoDTO){
        String testo = contenutoDTO.testo();
        boolean pending = contenutoDTO.pending();
        ContenutiStati  stati = contenutoDTO.stati();
        return new ContenutoBase(testo, pending, stati);
    }


}
