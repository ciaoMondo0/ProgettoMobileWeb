package main.java.com.it.unicam.progetto_ids_2023.model.factory;

import main.java.com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;

public interface ContenutoFactory {
    Contenuto createContenuto(ContenutoDTO contenutoDTO);

    public ContenutoTestuale createContenutoContest(ContenutoDTO contenutoDTO);
}
