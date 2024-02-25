package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.*;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import com.it.unicam.progetto_ids_2023.model.utente.TuristaAutenticato;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
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



    public void popolaRepository(){
        Comune camerino = new Comune("Camerino","Comune di Camerino");
        Comune macerata = new Comune("Macerata","Comune di Macerata");
        Comune ancona = new Comune("Ancona","Comune di Ancona");

        Contenuto c1 = new ContenutoBase("Sono un contenuto testuale",false);
        Contenuto c2 = new ContenutoBase("Sono un altro contenuto testuale",true);
        Contenuto c3 = new ContenutoBase("Sono il contenuto testuale numero 3",true);


       /* camerino.addContenuto(c1);
        macerata.addContenuto(c2);
        ancona.addContenuto(c3);*/

        PuntoFisico p1 = new PuntoFisico("punto fisico 1","descrizione del punto fisico 1",2,3);
        PuntoFisico p2 = new PuntoFisico("punto fisico 2","descrizione del punto fisico 2",77,58);
        PuntoFisico p3 = new PuntoFisico("punto fisico 3","descrizione del punto fisico 3",120,200);

        PuntoLogico pl1 = new PuntoLogico("punto logico 1","descrizione del punto logico 1");
        PuntoLogico pl2 = new PuntoLogico("punto logico 2","descrizione del punto logico 2");
        PuntoLogico pl3 = new PuntoLogico("punto logico 3","descrizione del punto logico 3");

        Itinerario i1 = new Itinerario("itinerario 1","descrizione itinerario");

        camerino.addPuntoDiInteresse(p1);

        i1.addPuntoFisico(p1);
        camerino.addPuntoDiInteresse(i1);

        camerino.addPuntoDiInteresse(pl3);
        macerata.addPuntoDiInteresse(p2);
        macerata.addPuntoDiInteresse(pl1);
        ancona.addPuntoDiInteresse(p3);
        ancona.addPuntoDiInteresse(pl2);

        comuneRepository.save(camerino);
        comuneRepository.save(macerata);
        comuneRepository.save(ancona);

        //POSSO POPOLARLO IN QUESTO MODO --> fare endpoint per popolare
    }


    /*COMUNI*/

    /*visualizza la lista dei comuni con relativi contenuti e punti di interesse*/
    /*Forse sarebbe meglio far vedere semplicemente una lista dei comuni presenti invece che tutto lo schema
    * dei comuni con i relativi punti di interesse e contenuti e i relativi punti di interesse e contenuti
    * per questi ultimi. Si potrebbe fare una lista di oggetti che contengano solo l'id del comune, il nome
    * e la descrizione.*/
    //STATO: OK
    public List<Comune> getComuni(){
        return comuneRepository.findAll();
    }


    /*aggiunge un comune*/
    /*PUO' FARLO SOLO IL GESTORE DELLA PIATTAFORMA*/
    //STATO: OK
    public Comune addComune(String nome, String descrizione){
        //TODO: controllo se i valori sono null o il comune esiste già
        return comuneRepository.save(new Comune(nome,descrizione));
    }

    /*modifica le informazioni di un comune scelto*/
    /*PUO' FARLO SOLO IL GESTORE DELLA PIATTAFORMA*/
    /*TODO:implementare*/

    //Da testare
    public Comune aggiornaComune(Long id, Utente utente) {
        if (utente.getRuolo().equals(Ruolo.GESTORE_PIATTAFORMA)) {
            Comune comune = comuneRepository.findById(id).orElseThrow();
            return comuneRepository.save(comune);
        }
        return null;
    }

    /*elimina il comune scelto*/
    /*PUO' FARLO SOLO IL GESTORE DELLA PIATTAFORMA*/
    /*TODO:implementare*/

    //Da testare
    public void eliminaComune(Long id, Utente utente) {
        if (utente.getRuolo().equals(Ruolo.GESTORE_PIATTAFORMA)) {
            Comune comune = comuneRepository.findById(id).orElseThrow();


            comuneRepository.delete(comune);
        } else {
            throw new IllegalArgumentException();
        }
    }




    /*CONTENUTI*/

    /*mostra la lista dei contenuti di un determinato comune*/
    //STATO: OK
    public List<Contenuto> getContenutiComune(Long id){
        return comuneRepository.findById(id).orElseThrow().getContenuti();
    }


    /*upload di un file nel comune scelto
     * BISOGNA IMPLEMENTARE L'UPLOAD DEL FILE TRAMITE SPRING
     * E MODIFICARE LA CLASSE CONTENUTO MULTIMEDIALE*/
//    public void addFileComune(Long id){
//        /*TODO:implementare*/
//    }

    /*Aggiunge un contenuto al comune selezionato*/
    //STATO: OK
    public void addContenutoComune(Long id, Contenuto contenuto){
        //TODO: controllo se comune non trovato e/o contenuto null
        //TODO: gestire l'upload di un file per il contenuto multimediale
        Comune comune = comuneRepository.findById(id).orElseThrow();
        comune.addContenuto(contenuto);
        comuneRepository.save(comune);
    }




    /*PUNTI DI INTERESSE*/

    /*Aggiunge un punto di interesse generico al comune dato,
    * nel body della richiesta va specificato il "tipo" di punto di interesse*/
    //STATO: OK
    public void addPOI(Long id, PuntoDiInteresse puntoDiInteresse){
        //TODO: controllo se comune non trovato e/o POI null
        Comune comune = comuneRepository.findById(id).orElseThrow();
        comune.addPuntoDiInteresse(puntoDiInteresse);
        comuneRepository.save(comune);
    }

    /*Visualizza tutti i punti di interesse di un comune dato*/
    //STATO: OK
    public List<PuntoDiInteresse> getPOIS(Long id){
        //TODO: controllo se comune non trovato
        return comuneRepository.findById(id).orElseThrow().getPuntiDiInteresse();
    }

    /*Visualizza tutti i contenuti di un POI in un determinato comune*/
    //STATO: OK
    public List<Contenuto> getContenutiPOI(Long idComune, Long idPOI){
        //TODO: controllo se comune non trovato e/o POI non trovato
        List<Contenuto> contenuti = new ArrayList<>();
        for(PuntoDiInteresse puntoDiInteresse:getPOIS(idComune)){
            if(Objects.equals(puntoDiInteresse.getId(),idPOI)){
                contenuti.addAll(puntoDiInteresse.getContenuti());
            }
        }
        return contenuti;
    }

    /*Aggiunge del contenuto ad un punto di interesse:
    vegono passati l'id del comune nel quale è presente il poi,
    l'id del poi (presente nella lista del comune) e il contenuto da inserire */
    public void addContenutoPOI(Long idComune,Long idPOI, Contenuto contenuto){
        //TODO: controllo se il contenuto è null, comune non trovato o poi non trovato
        for(PuntoDiInteresse puntoDiInteresse:getPOIS(idComune)){
            if(Objects.equals(puntoDiInteresse.getId(),idPOI)){
                puntoDiInteresse.addContenuto(contenuto);
            }
        }
    }

    /*ITINERARIO*/

    /*Visualizza tutti gli itinerari di un determinato comune*/
    public List<Itinerario> getItinerari(Long idComune){
        List<Itinerario> itinerari = new ArrayList<>();
        for(PuntoDiInteresse puntoDiInteresse:getPOIS(idComune)){
            if(puntoDiInteresse instanceof Itinerario)
                itinerari.add((Itinerario) puntoDiInteresse);
        }
        return itinerari;
    }


    /*Visualizza tutti i punti fisici che compongono l'itinerario*/
    public List<PuntoFisico> getPuntiFisiciItinerario(Long idComune,Long idItinerario){
        List<PuntoFisico> puntifisici = new ArrayList<>();
        for(Itinerario itinerario:getItinerari(idComune)){
            if(Objects.equals(itinerario.getId(),idItinerario))
                puntifisici.addAll(itinerario.getPuntiFisici());
        }
        return puntifisici;
    }

    /*DA IMPLEMENTARE*/

    public void addPOIFisicoItinerario(){}
    public void addPOIEvento(){}
    public void getEventi(){}


    /*CONTEST*/

    /*SOLO ANIMATORE*/
    //Da testare
    public void addContest(Long Id,String tematica, boolean pubblico, Utente utente){
        if (utente.getRuolo() == Ruolo.ANIMATORE) {
            Contest contest = new Contest(tematica, pubblico);
            Comune comune = comuneRepository.findById(Id).orElseThrow();
            comune.addContest(contest);
            comuneRepository.save(comune);
        } else {
            throw new IllegalArgumentException();
        }
    }




    /*CASI D'USO*/
    public void segnalaContenuto(){/*TODO:implementare*/}

    /*TURISTA AUTENTICATO*/
    public void salvaInformazioni(Long utenteId, PuntoDiInteresse puntoDiInteresse){
        TuristaAutenticato turista = turistaAutenticatoRepository.findById(utenteId).orElseThrow();
        turista.setPuntoDiInteresse(puntoDiInteresse);
        turistaAutenticatoRepository.save(turista);
        /*TODO:implementare*/}


    /*CURATORE*/
    public void verificaContenuto(){/*TODO:implementare*/}
    public void creaPostSocial(){/*TODO:implementare*/}


    /*ANIMATORE*/
    public void creaContest(){/*TODO:implementare*/}
    public void validaContenutoContest(){/*TODO:implementare*/}


    /*GESTORE PIATTAFORMA*/
    public void gestisceRichiesteContributor(){/*TODO:implementare*/}



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
//    /*Aggiungiamo un punto fisico già presente nel comune oppure ne creaiamo un nuovo vuoto?*/
//    public void addPuntoFisicoItinerario(){}

    /*Aggiunge un punto di interesse fisico geolocalizzato all'interno del comune scelto*/
//    public void addPuntoFisico(Long id, String nome, String descrizione, double latitudine, double longitudine){
//        PuntoFisico puntoFisico = new PuntoFisico(nome,descrizione,latitudine,longitudine);
//        Comune comune = comuneRepository.findById(id).orElseThrow();
//        comune.addPuntoDiInteresse(puntoFisico);
//        comuneRepository.save(comune);
//    }
//
//    /*Aggiunge un punto di interesse logico all'interno del comune scelto*/
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
