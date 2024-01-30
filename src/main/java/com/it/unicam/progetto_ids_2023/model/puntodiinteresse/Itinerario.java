package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Itinerario extends PuntoDiInteresse {
    @ElementCollection(targetClass = PuntoFisico.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "punti_fisici", joinColumns = @JoinColumn(name = "punto_fisico_id"))
//    //@Column(name = "contenuto", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<PuntoFisico> puntiFisici;

    public Itinerario(){}

    public Itinerario(String nome, String descrizione) {
        super(nome,descrizione);
        this.puntiFisici = new ArrayList<>();
        this.contenuti = new ArrayList<>();
    }

    public List<PuntoFisico> getPuntiFisici() {
        return puntiFisici;
    }

    public void setPuntiFisici(List<PuntoFisico> puntiFisici) {
        this.puntiFisici = puntiFisici;
    }

//    public List<Contenuto> getContenuti(){
//        List<Contenuto> contenuti = new ArrayList<>();
//        for(PuntoDiInteresse puntoDiInteresse : getPuntiFisici())
//            contenuti.addAll(puntoDiInteresse.getContenuti());
//        return contenuti;
//    }
    public void addPuntoFisico(PuntoFisico puntoFisico){
    puntiFisici.add(puntoFisico);
}
}
