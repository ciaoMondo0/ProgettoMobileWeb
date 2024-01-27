package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import com.it.unicam.progetto_ids_2023.repository.PuntiDiInteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;

    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }



    public void popolaRepository(){
        comuneRepository.save(new Comune("Camerino","Comune di Camerino"));
        comuneRepository.save(new Comune("Macerata","Comune di Macerata"));
    }

    /*lista comuni con relativi contenuti e punti di interesse*/
    public List<Comune> getComuni(){
        return comuneRepository.findAll();
    }

    /*aggiunge del contenuto al comune, la richiesta va effettuata in JSON*/
    public void addContenutoComune(Long id,Contenuto contenuto){
        Comune comune = comuneRepository.findById(id).get();
        comune.addContenuto(contenuto);
        comuneRepository.save(comune);
    }


    /*aggiunge un comune*/
    /*PUO' FARLO SOLO IL GESTORE DELLA PIATTAFORMA*/
    public Comune addComune(String nome, String descrizione){
        return comuneRepository.save(new Comune(nome,descrizione));
    }

    /*mostra la lista dei contenuti di un determinato comune*/
    public List<Contenuto> getContenutiComune(Long id){
        return comuneRepository.findById(id).orElseThrow().getContenuti();
    }

}
