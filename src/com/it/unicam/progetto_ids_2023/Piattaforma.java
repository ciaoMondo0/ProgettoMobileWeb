package com.it.unicam.progetto_ids_2023;


import com.it.unicam.progetto_ids_2023.utenti.Ruolo;
import com.it.unicam.progetto_ids_2023.utenti.Utente;
import com.it.unicam.progetto_ids_2023.view.IContribuzione;

import java.util.Scanner;

public class Piattaforma {
    public static void main(String[] args) {

        Utente u1 = new Utente("Luca");


        IContribuzione ic = new IContribuzione();
        ic.visualizza(new Scanner(System.in));

        //IPrincipale ip = new IPrincipale();
        //ip.visualizza(new Scanner(System.in));
    }
}
