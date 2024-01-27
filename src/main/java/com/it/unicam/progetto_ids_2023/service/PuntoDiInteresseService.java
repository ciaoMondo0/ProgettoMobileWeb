package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoLogico;
import com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import com.it.unicam.progetto_ids_2023.repository.PuntiDiInteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoDiInteresseService {

    private PuntiDiInteresseRepository puntiDiInteresseRepository;
    private ContenutoRepository contenutoRepository;

    @Autowired
    public PuntoDiInteresseService(PuntiDiInteresseRepository puntiDiInteresseRepository, ContenutoRepository contenutoRepository) {
        this.puntiDiInteresseRepository = puntiDiInteresseRepository;
        this.contenutoRepository = contenutoRepository;
    }


//    public List<Comune> getComuni(){
//        return puntiDiInteresseRepository.findAll();
//    }






//    public void popolaRepository(){
//        PuntoDiInteresse camerino = new Comune("Camerino","Comune di Camerino");
//
//        //SALVO I COMUNI NELLA REPOSITORY
//        puntiDiInteresseRepository.save(camerino);
//    }

}
