package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoLogico;
import com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
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



    public void popolaRepository(){
        comuneRepository.save(new Comune("Camerino","Comune di Camerino"));
        comuneRepository.save(new Comune("Macerata","Comune di Macerata"));
    }


    /*COMUNI*/

    /*visualizza la lista dei comuni con relativi contenuti e punti di interesse*/
    public List<Comune> getComuni(){
        return comuneRepository.findAll();
    }


    /*aggiunge un comune*/
    /*PUO' FARLO SOLO IL GESTORE DELLA PIATTAFORMA*/
    public Comune addComune(String nome, String descrizione){
        return comuneRepository.save(new Comune(nome,descrizione));
    }

    /*modifica le informazioni di un comune scelto*/
    /*PUO' FARLO SOLO IL GESTORE DELLA PIATTAFORMA*/
    /*TODO:implementare*/
    public void aggiornaComune(){}

    /*elimina il comune scelto*/
    /*PUO' FARLO SOLO IL GESTORE DELLA PIATTAFORMA*/
    /*TODO:implementare*/
    public void eliminaComune(){}



    /*CONTENUTI*/

    /*mostra la lista dei contenuti di un determinato comune*/
    public List<Contenuto> getContenutiComune(Long id){
        return comuneRepository.findById(id).orElseThrow().getContenuti();
    }

    /*aggiunge del contenuto testuale al comune*/
    public void addTestoComune(Long id, String testo, boolean pending){
        Comune comune = comuneRepository.findById(id).orElseThrow();
        Contenuto contenuto = new ContenutoTestuale(testo,pending);
        comune.addContenuto(contenuto);
        comuneRepository.save(comune);
    }

    /*upload di un file nel comune scelto
     * BISOGNA IMPLEMENTARE L'UPLOAD DEL FILE TRAMITE SPRING
     * E MODIFICARE LA CLASSE CONTENUTO MULTIMEDIALE*/
    public void addFileComune(Long id){
        /*TODO:implementare*/
    }




    /*PUNTI DI INTERESSE*/

    /*Aggiunge un punto di interesse fisico geolocalizzato all'interno del comune scelto*/
    public void addPuntoFisico(Long id, String nome, String descrizione, double latitudine, double longitudine){
        PuntoFisico puntoFisico = new PuntoFisico(nome,descrizione,latitudine,longitudine);
        Comune comune = comuneRepository.findById(id).orElseThrow();
        comune.addPuntoDiInteresse(puntoFisico);
        comuneRepository.save(comune);
    }

    /*Aggiunge un punto di interesse logico all'interno del comune scelto*/
    public void addPuntoLogico(Long id, String nome, String descrizione){
        PuntoLogico puntoLogico = new PuntoLogico(nome,descrizione);
        Comune comune = comuneRepository.findById(id).orElseThrow();
        comune.addPuntoDiInteresse(puntoLogico);
        comuneRepository.save(comune);
    }

    /*METODO DI PROVA*/
    public void aggiungiPOI(Long id, PuntoLogico puntoLogico){
        Comune comune = comuneRepository.findById(id).orElseThrow();
        comune.addPuntoDiInteresse(puntoLogico);
        comuneRepository.save(comune);
    }

    /*Aggiunge un evento all'interno del comune scelto*/
    public void addEvento(){/*TODO:implementare*/}

    /*Aggiunge un itinerario all'interno del comune scelto*/
    public void addItinerario(){/*TODO:implementare*/}



    /*CONTEST*/

    /*SOLO ANIMATORE*/
    public void addContest(){/*TODO:implementare*/}




    /*CASI D'USO*/
    public void segnalaContenuto(){/*TODO:implementare*/}

    /*TURISTA AUTENTICATO*/
    public void salvaInformazioni(){/*TODO:implementare*/}


    /*CURATORE*/
    public void verificaContenuto(){/*TODO:implementare*/}
    public void creaPostSocial(){/*TODO:implementare*/}


    /*ANIMATORE*/
    public void creaContest(){/*TODO:implementare*/}
    public void validaContenutoContest(){/*TODO:implementare*/}


    /*GESTORE PIATTAFORMA*/
    public void gestisceRichiesteContributor(){/*TODO:implementare*/}





}
