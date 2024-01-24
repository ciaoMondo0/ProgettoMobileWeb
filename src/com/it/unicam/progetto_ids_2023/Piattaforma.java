package com.it.unicam.progetto_ids_2023;


import com.it.unicam.progetto_ids_2023.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.contenuto.ContenutoMultimediale;
import com.it.unicam.progetto_ids_2023.contenuto.Controller;
import com.it.unicam.progetto_ids_2023.puntidiinteresse.PuntoDiInteresse;
import com.it.unicam.progetto_ids_2023.puntidiinteresse.PuntoFisico;
import com.it.unicam.progetto_ids_2023.utenti.Contributor;
import com.it.unicam.progetto_ids_2023.utenti.TuristaAutenticato;
import com.it.unicam.progetto_ids_2023.utenti.Utente;

public class Piattaforma {
    public static void main(String[] args) {

        //Utente u1 = new Curatore("paolo","paolociao");
        //u1.getRuolo();
        //System.out.println(u1.getEmail());



        //PuntoDiInteresse puntoDiInteresse = new PuntoFisico(1,"luca","descrizione",52,53);
        //System.out.println(puntoDiInteresse.getNome());

        //IContribuzione ic = new IContribuzione();
        //ic.visualizza(new Scanner(System.in));

        //IPrincipale ip = new IPrincipale();
        //ip.visualizza(new Scanner(System.in));

        //Contenuto contenuto = new ContenutoMultimediale("hello",false);
        //contenuto.setPending(true);
        //System.out.println(contenuto.isPending());

        PuntoDiInteresse puntoDiInteresse = new PuntoFisico(1,"luca","descrizione",52,53);
        Contenuto contenuto = new ContenutoMultimediale("hello",false);
        Utente utente = new Contributor("Mario","mariorossi@gmail.com");
        Utente utente2 = new TuristaAutenticato("Luigi","luigiverdi@gmail.com");
        Controller gestoreContenuto = new Controller(utente2);
        boolean status = gestoreContenuto.addContenutoPOI(puntoDiInteresse,contenuto);

        System.out.println(status);
    }

    /* TODO:
    *   -richieste contributor
    *   -spostare metodi observer
    *   -gestione partecipanti contest
    *   -aree personali gestore, curatore e turista autenticato
    *   -salvataggio contenuto */

}
