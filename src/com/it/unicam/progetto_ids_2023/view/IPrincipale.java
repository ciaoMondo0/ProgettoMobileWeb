package com.it.unicam.progetto_ids_2023.view;

import java.util.Scanner;

public class IPrincipale {
    public IPrincipale() {
    }

    public void visualizza(Scanner input){
        int scelta;
        while (true){
            System.out.println("1- Accedi");
            System.out.println("2- Lista comuni");
            System.out.println("0- Esci");
            System.out.print("Scegli: ");
            scelta = input.nextInt();
            if(scelta == 1){
                //TODO: login
                break;
            }
            if(scelta == 2){
                //TODO: visualizza lista comuni
                break;
            }
            if (scelta == 0) break;
        }
        input.close();
    }
}
