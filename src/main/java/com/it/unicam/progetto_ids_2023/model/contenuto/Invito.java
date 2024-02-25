package com.it.unicam.progetto_ids_2023.model.contenuto;


import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Invito {

   @GeneratedValue
    @Id
    private Long id;
    private String emailDestinatario;

    private String contenuto;


   @ManyToOne
    @JoinColumn(name = "contest_id")
    private Contest contest;


    @OneToMany
    @JoinColumn(name = "utente_id")
    private List<Utente> utente;

    public Invito(String contenuto) {
        this.contenuto = contenuto;

    }

    public Invito() {

    }


    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
