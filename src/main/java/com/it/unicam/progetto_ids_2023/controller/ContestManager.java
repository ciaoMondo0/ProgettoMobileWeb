package com.it.unicam.progetto_ids_2023.controller;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contest;
import com.it.unicam.progetto_ids_2023.model.utente.Contributor;

import java.util.ArrayList;
import java.util.List;

public class ContestManager {

    private List<Contenuto> contenuti;
    private List<Contest> contests;

    public ContestManager(){
        contests = new ArrayList<Contest>();
        contenuti = new ArrayList<Contenuto>();
    }


    public void newContest(String data, String obiettivo, boolean pubblico, List<Contributor> partecipanti, List<Contenuto> contenuti){
        Contest contest = new Contest(data, obiettivo, pubblico, partecipanti, contenuti);
        contests.add(contest);
    }


    //Modificare
    public void addContenuto(Contenuto contenuto){
        if(contenuto != null) {
            contenuti.add(contenuto);
        } else {
            throw new IllegalArgumentException();
        }
    }


  //Chiudere i contest una volta raggiunta la data di fine
    public void closeContest(String data){
        for(Contest contest: contests){
            if(contest.getData().equals(data)){
                contest.setAperto(false);
            }
        }
    }


    //Mandare inviti ai partecipanti
    public void sendInviti(Contest contest){
        List<Contributor> partecipanti = contest.getPartecipanti();
        for(Contributor contributor : partecipanti){
            System.out.println("Invito inviato a: " + contributor.getNome());
        }

    }

    public void deleteContest(Contest contest){
        if(contests.contains(contest)){
            contests.remove(contest);
        } else {
            throw new IllegalArgumentException("Nessun contest presente");
        }
    }

    //Aggiungere metodo per gli inviti privati








}
