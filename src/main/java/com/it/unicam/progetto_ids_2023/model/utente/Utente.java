package com.it.unicam.progetto_ids_2023.model.utente;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.contenuto.Invito;
import com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
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
    private String password;
    @Enumerated(EnumType.STRING)

    private Ruolo ruolo;
    private boolean autorizzatoCreazioneContenuto;

    @ManyToMany
    @JoinTable(
            name = "utente_preferiti_contenuti",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "contenuto_id"))
    private List<Contenuto> preferitiContenuti;

    // Relazione per i punti di interesse preferiti
    @ManyToMany
    @JoinTable(
            name = "utente_preferiti_punti_di_interesse",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "punto_di_interesse_id"))
    private List<PuntoDiInteresse> preferitiPuntiDiInteresse;







/*
    @OneToMany(mappedBy = "utente")
    private List<Invito> inviti;
*/
/*
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contenuto_id")

    private Contenuto contenuto; */

    public Utente() {
    }

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Utente(long l, String nome, String mail, Ruolo ruolo, boolean b, String password) {
        this.id = l;
        this.nome = nome;
        this.email = mail;
        this.ruolo = ruolo;
        this.autorizzatoCreazioneContenuto = b;
        this.password = password;
    }

    public Utente(Ruolo ruolo, String nome, String mail, String password) {
        this.nome = nome;
        this.email = mail;
        this.ruolo = ruolo;
        this.password = password;
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

    public Ruolo getRuolo() {
        return this.ruolo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isContributorAutorizzato() {
        return autorizzatoCreazioneContenuto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public List<Contenuto> getPreferitiContenuti() {
        return preferitiContenuti;
    }

    public void setPreferitiContenuti(List<Contenuto> preferitiContenuti) {
        this.preferitiContenuti = preferitiContenuti;
    }

    public List<PuntoDiInteresse> getPreferitiPuntiDiInteresse() {
        return preferitiPuntiDiInteresse;
    }

    public void setPreferitiPuntiDiInteresse(List<PuntoDiInteresse> preferitiPuntiDiInteresse) {
        this.preferitiPuntiDiInteresse = preferitiPuntiDiInteresse;
    }
}