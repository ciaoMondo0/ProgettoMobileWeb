package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.*;
import com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import com.it.unicam.progetto_ids_2023.repository.TuristaAutenticatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;
    private TuristaAutenticatoRepository turistaAutenticatoRepository;

    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }



    public List<Comune> getComuni(){
        return comuneRepository.findAll();
    }

    public Comune addComune(String nome, String descrizione){
        return comuneRepository.save(new Comune(nome,descrizione));
    }

    public Comune aggiornaComune(Long id) {

        Comune comune = comuneRepository.findById(id).orElseThrow();
        return comuneRepository.save(comune);


    }



    public void eliminaComune(Long id){
        Comune comune = comuneRepository.findById(id).orElseThrow();
        comuneRepository.delete(comune);

    }







    /*VECCHI METODI*/
//    /*Aggiunge un evento all'interno del comune scelto*/
//    public void addEvento(){}
//
//    /*Aggiunge un itinerario all'interno del comune scelto*/
//    public void addItinerario(Long id, String nome, String descrizione){
//        Itinerario itinerario = new Itinerario(nome, descrizione);
//        Comune comune = comuneRepository.findById(id).orElseThrow();
//        comune.addPuntoDiInteresse(itinerario);
//        comuneRepository.save(comune);
//    }
//
//    public void addTestoItinerario(){}
//    public void addMediaItinerario(){}
//    /*Aggiungiamo un punto fisico già presente nel comune oppure ne creaiamo un nuovo vuoto*/
//    public void addPuntoFisicoItinerario(){}

    /*Aggiunge un punto di interesse fisico geolocalizzato all'interno del comune */
//    public void addPuntoFisico(Long id, String nome, String descrizione, double latitudine, double longitudine){
//        PuntoFisico puntoFisico = new PuntoFisico(nome,descrizione,latitudine,longitudine);
//        Comune comune = comuneRepository.findById(id).orElseThrow();
//        comune.addPuntoDiInteresse(puntoFisico);
//        comuneRepository.save(comune);
//    }
//
//    /*Aggiunge un punto di interesse logico all'interno del comune */
//    public void addPuntoLogico(Long id, String nome, String descrizione){
//        PuntoLogico puntoLogico = new PuntoLogico(nome,descrizione);
//        Comune comune = comuneRepository.findById(id).orElseThrow();
//        comune.addPuntoDiInteresse(puntoLogico);
//        comuneRepository.save(comune);
//    }

    /*Visualizza tutti i punti fisici che compongono l'itinerario*/
    //STATO: OK
//    public List<PuntoFisico> getPuntiFisiciItinerario(Long idComune, Long idItinerario){
//        //controllo se il punto non è un itinerario, se il comune non trovato o se il poi non trovato//
//        List<PuntoFisico> puntifisici = new ArrayList<>();
//        for(PuntoDiInteresse puntoDiInteresse:getPOIS(idComune)) {
//            if (Objects.equals(puntoDiInteresse.getId(), idItinerario)) {
//                if(puntoDiInteresse instanceof Itinerario){
//                    Itinerario itinerario = new Itinerario(puntoDiInteresse.getNome(),puntoDiInteresse.getDescrizione());
//                    itinerario.setPuntiFisici(((Itinerario) puntoDiInteresse).getPuntiFisici());
//                    puntifisici.addAll(itinerario.getPuntiFisici());
//                }
//            }
//        }
//        return puntifisici;
//    }


}
