package com.it.unicam.progetto_ids_2023.model.contenuto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data

public class Contest{
    /*Il contest contiene una tematica, una lista di contenuti, un valore booleano che indica se il contest
     * è pubblico (aperto a tutti) oppure se è chiuso. Se il contest è chiuso, viene inizializzata la lista
     * degli invitati, che conterrà le email dei partecipanti */

    private String tematica;

    @OneToMany
    @JoinColumn(name = "contenuto_id")

    private List<Contenuto> contenuti;




    @OneToMany
    @JoinColumn(name = "invito_id")


    private List<Invito> inviti;


    private boolean pubblico;
    @ElementCollection
    private List<String> listaInvitati;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contenuto_id")

    private Contenuto contenutoBase;

    private LocalDateTime inizio;
    private LocalDateTime fine;

    private boolean closed;

    public Contest(String tematica, boolean pubblico) {
        this.tematica = tematica;
        // this.contenuti = new ArrayList<>();
        this.pubblico = pubblico;
        this.closed = false;

        //se il contest non è aperto a tutti inizializza la lista di invitati (conterrà le email degli invitati)
        if(!pubblico) this.listaInvitati = new ArrayList<>();
    }

    public Contest(String tematica, boolean pubblico,LocalDateTime inizio, LocalDateTime fine ){
        this.id = id;
        this.tematica = tematica;
        this.pubblico = pubblico;
        this.inizio = inizio;
        this.fine = fine;
    }


    public Contest(Long id, String tematica, boolean pubblico) {
        this.id = id;
        this.tematica = tematica;
        this.pubblico = pubblico;

    }



    public Contest() {

    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }


    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }



    public boolean isPubblico() {
        return pubblico;
    }

    public void setPubblico(boolean pubblico) {
        this.pubblico = pubblico;
    }

    public List<String> getListaInvitati() {
        return listaInvitati;
    }

    public void setListaInvitati(List<String> listaInvitati) {
        this.listaInvitati = listaInvitati;
    }

    public void setClosed(boolean isClosed) {
        this.closed = isClosed;
    }
    public boolean getClosed(){
        return closed;
    }

    public LocalDateTime getInizio() {
        return inizio;
    }

    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public LocalDateTime getFine() {
        return fine;
    }

    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }

    public Contenuto getContenutoBase() {
        return contenutoBase;
    }

    public void setContenutoBase(Contenuto contenutoBase) {
        this.contenutoBase = contenutoBase;
    }
}