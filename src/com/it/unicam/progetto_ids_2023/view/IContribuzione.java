package com.it.unicam.progetto_ids_2023.view;

import java.util.Scanner;

public class IContribuzione {
    public IContribuzione() {
    }

    public void visualizza(Scanner input){
        int scelta;
        while(true){
            System.out.println("1- Crea POI");
            System.out.println("2- Crea itinerario");
            System.out.println("3- Crea evento");
            System.out.println("4- Carica contenuto");
            System.out.println("0- Esci");
            System.out.print("Scegli: ");
            scelta = input.nextInt();
            if(scelta == 1){
                //TODO: crea POI
                break;
            }
            if(scelta == 2){
                //TODO: crea itinerario
                break;
            }
            if (scelta == 0) break;
        }
        }
    }
