package main.java.com.it.unicam.progetto_ids_2023.model.factory;

import main.java.com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.StatoSegnalazioni;
import main.java.com.it.unicam.progetto_ids_2023.repository.SegnalazioniRepository;

public interface SegnalazioneFactory {


    Segnalazione createSegnalazione(SegnalazioniDTO segnalazioniDto);

}
