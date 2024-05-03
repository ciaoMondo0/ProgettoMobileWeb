package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import com.it.unicam.progetto_ids_2023.dto.ContenutoBaseDTO;
import com.it.unicam.progetto_ids_2023.dto.ContenutoMultimedialeDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.*;
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
    public Contenuto createContenuto(ContenutoDTO contenutoDTO) {



        String nome = contenutoDTO.nome();
        String testo = contenutoDTO.testo();
        boolean pending = contenutoDTO.pending();
        ContenutiStati stati = contenutoDTO.stati();



        ContenutoTipo tipoContenuto = contenutoDTO.tipo();
        if (tipoContenuto == ContenutoTipo.TESTUALE) {
            return new ContenutoBase(contenutoDTO.testo(), pending,  stati, nome);
        } else if (tipoContenuto == ContenutoTipo.MULTIMEDIALE) {
            return new ContenutoMultimediale(contenutoDTO.file(), contenutoDTO.pending(), contenutoDTO.nome());
        } else {
            throw new IllegalArgumentException("Tipo di contenuto non supportato");
        }




    }

    public ContenutoMultimediale createContenutoMultimediale(ContenutoMultimedialeDTO contenutoMultimedialeDTO){
        String file = contenutoMultimedialeDTO.file();
        boolean pending = contenutoMultimedialeDTO.pending();
        String nome = "";
        return new ContenutoMultimediale(file, pending, nome);
    }


    public ContenutoBase createContenutoContest(ContenutoDTO contenutoDTO){
        String testo = contenutoDTO.testo();
        boolean pending = contenutoDTO.pending();
        ContenutiStati  stati = contenutoDTO.stati();
        String nome = contenutoDTO.nome();
        return new ContenutoBase(testo, pending, stati, nome);
    }


}
