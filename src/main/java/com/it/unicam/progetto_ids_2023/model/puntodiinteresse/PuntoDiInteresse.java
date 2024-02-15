package com.it.unicam.progetto_ids_2023.model.puntodiinteresse;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoMultimediale;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoTestuale;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PuntoFisico.class, name = "fisico"),
        @JsonSubTypes.Type(value = PuntoLogico.class, name = "logico"),
        @JsonSubTypes.Type(value = Itinerario.class, name = "itinerario"),
        @JsonSubTypes.Type(value = Evento.class, name = "evento")
})
public  class PuntoDiInteresse {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String descrizione;

    @ElementCollection(targetClass = Contenuto.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "contenuti", joinColumns = @JoinColumn(name = "id_poi_associato"))
//    //@Column(name = "contenuto", nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
//    @JdbcTypeCode(SqlTypes.JSON)
    protected List<Contenuto> contenuti;

    public PuntoDiInteresse(){}

    public PuntoDiInteresse(String nome, String descrizione){
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Contenuto> getContenuti(){
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }

    public void addContenuto(Contenuto contenuto){
        getContenuti().add(contenuto);
    }
}

