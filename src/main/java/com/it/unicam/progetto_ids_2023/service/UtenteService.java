package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.dto.UtenteDTO;
import com.it.unicam.progetto_ids_2023.model.factory.UtenteFactory;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.model.utente.Ruolo;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.PuntoFisicoRepository;
import com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtenteService {

  //  private UtenteRepository



    @Autowired
    private PuntoFisicoRepository puntoDiInteresseRepository;
    private UtenteRepository utenteRepository;

    private UtenteFactory utenteFactory;


    public UtenteService(PuntoFisicoRepository puntoDiInteresseRepository,UtenteRepository utenteRepository, UtenteFactory utenteFactory){
        this.puntoDiInteresseRepository = puntoDiInteresseRepository;
        this.utenteRepository = utenteRepository;
        this.utenteFactory = utenteFactory;
    }



    public List<PuntoFisico> trovaPuntiDiInteresse(String searchString) {
        return null;
    }






    public void assegnaRuolo(Long id, Ruolo ruolo){
       //

    }

    public Utente login(String email, String password) {
      //
        return null;
    }

    public void registrazione(UtenteDTO utenteDTO){
      //

    }

    public void cancellaUtente(Long utenteId){
       //
    }


    public void salvaInformazioni(){

    }

    public List<Utente> getAll(){
      return null;
    }



}
