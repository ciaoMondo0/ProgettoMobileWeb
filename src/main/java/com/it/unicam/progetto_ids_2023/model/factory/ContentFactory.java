package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.*;
import com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoMultimedialeRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoTestualeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ContentFactory implements ContenutoFactory {

    private final ContenutoTestualeRepository testoRepo;
    private final ContenutoMultimedialeRepository multiRepo;
    private final ComuneRepository comuneRepo;

    @Autowired
    public ContentFactory(ContenutoTestualeRepository testoRepo, ContenutoMultimedialeRepository multiRepo, ComuneRepository comuneRepo) {
        this.testoRepo = testoRepo;
        this.multiRepo = multiRepo;
        this.comuneRepo = comuneRepo;
    }
    @Override
    public Contenuto createContenuto(ContenutoDTO contenutoDTO) {



        String nome = contenutoDTO.nome();
        String testo = contenutoDTO.testo();
        boolean pending = true;
        ContenutiStati stati = ContenutiStati.PENDING;



        ContenutoTipo tipoContenuto = contenutoDTO.tipo();
        if (tipoContenuto == ContenutoTipo.TESTUALE) {
            return new ContenutoTestuale(contenutoDTO.testo(), pending,  stati, nome);
        } else if (tipoContenuto == ContenutoTipo.MULTIMEDIALE) {
            return new ContenutoMultimediale(contenutoDTO.file(), pending, stati, contenutoDTO.nome());
        } else {
            throw new IllegalArgumentException("Tipo di contenuto non supportato");
        }




    }



    public ContenutoTestuale createContenutoContest(ContenutoDTO contenutoDTO){
        String testo = contenutoDTO.testo();
        String nome = contenutoDTO.nome();
        boolean pending = false;
        ContenutiStati stati = ContenutiStati.ACCETTATO;
        return new ContenutoTestuale(testo, pending, stati, nome);
    }


}
