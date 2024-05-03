package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.Comune;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;

public interface IContenuto {
    boolean isPending();
    void setPending(boolean pending);
    ContenutiStati getStati();
    void setStati(ContenutiStati stati);
    Long getId();
    void setId(Long id);
    ContenutoTipo getTipo();
    void setTipo(ContenutoTipo tipo);
    String getNome();
    void setNome(String nome);
    Utente getUtente();
    void setUtente(Utente utente);

    Comune getComune();

    void setComune(Comune comune);


}