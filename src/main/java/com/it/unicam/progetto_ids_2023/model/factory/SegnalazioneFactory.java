package com.it.unicam.progetto_ids_2023.model.factory;

import com.it.unicam.progetto_ids_2023.dto.SegnalazioniDTO;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Segnalazione;
import com.it.unicam.progetto_ids_2023.model.contenuto.StatoSegnalazioni;
import com.it.unicam.progetto_ids_2023.repository.SegnalazioniRepository;

public interface SegnalazioneFactory {


    Segnalazione createSegnalazione(SegnalazioniDTO segnalazioniDto);

}
