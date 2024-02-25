package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class BaseDiConoscenza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany
    @JoinColumn(name = "comune_id")
    private List<Comune> comune = new ArrayList<>();

    public BaseDiConoscenza() {
    }

    public BaseDiConoscenza(List<Comune> comune) {
        this.comune = comune;
    }

    public List<Comune> getComuni() {
        return comune;
    }

    public void setComuni(List<Comune> comune) {
        this.comune = comune;
    }
}
