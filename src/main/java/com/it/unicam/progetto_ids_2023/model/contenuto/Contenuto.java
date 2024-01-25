package com.it.unicam.progetto_ids_2023.model.contenuto;

public abstract class Contenuto {
    /* il contenuto è in stato di pending (deve essere validato) */
    private boolean pending;

    public Contenuto(boolean pending) {
        this.pending = pending;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public abstract String getContenuto();
}
