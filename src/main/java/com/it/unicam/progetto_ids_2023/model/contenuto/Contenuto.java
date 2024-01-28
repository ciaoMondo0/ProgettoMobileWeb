package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        property = "tipo"
//)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = ContenutoTestuale.class, name = "testo"),
//        @JsonSubTypes.Type(value = ContenutoMultimediale.class, name = "media")
//})
public abstract class Contenuto {
    @Id
    @GeneratedValue
    private long id;
    /* il contenuto è in stato di pending (deve essere validato) */
    private boolean pending;

    public Contenuto(){}

    public Contenuto(boolean pending) {
        this.pending = pending;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public abstract String getContenuto();
}
