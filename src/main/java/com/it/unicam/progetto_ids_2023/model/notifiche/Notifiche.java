package com.it.unicam.progetto_ids_2023.model.notifiche;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notifiche {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String destinatario;
        /*
                @ManyToOne
                private Contenuti contenuti;
        */
        private boolean letto;


}