package com.it.unicam.progetto_ids_2023.model.utente;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.Invito;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.util.List;


@Entity
@Table (name = "utente")
@Data

public  class Utente {



   @Id
   @GeneratedValue
   private Long id;
    private String nome;
    private String email;
    @Enumerated(EnumType.STRING)

    private Ruolo ruolo;
    private boolean autorizzatoCreazioneContenuto;



/*
    @OneToMany(mappedBy = "utente")
    private List<Invito> inviti;
*/
/*
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contenuto_id")

    private Contenuto contenuto; */

    public Utente(){}

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Utente(long l, String nome, String mail, Ruolo ruolo, boolean b) {
        this.id = l;
        this.nome = nome;
        this.email = mail;
        this.ruolo = ruolo;
        this.autorizzatoCreazioneContenuto = b;
    }

    public Utente(Ruolo ruolo, String nome, String mail){
        this.nome = nome;
        this.email = mail;
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  Ruolo getRuolo(){
        return this.ruolo;
    }

    public boolean isContributorAutorizzato() {
        return autorizzatoCreazioneContenuto;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}