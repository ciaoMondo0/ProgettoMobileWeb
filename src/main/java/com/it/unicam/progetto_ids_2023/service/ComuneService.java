package main.java.com.it.unicam.progetto_ids_2023.service;

import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.*;
import main.java.com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }



    public List<Comune> getComuni(){
        return comuneRepository.findAll();
    }

    public Comune addComune(String nome, String descrizione, Coordinate coordinate){
        return comuneRepository.save(new Comune(nome,descrizione, coordinate));
    }

    public Comune aggiornaComune(Long id) {

        Comune comune = comuneRepository.findById(id).orElseThrow();
        return comuneRepository.save(comune);


    }



    public void eliminaComune(Long id){
        Comune comune = comuneRepository.findById(id).orElseThrow();
        comuneRepository.delete(comune);

    }





}
