package com.it.unicam.progetto_ids_2023.contenuto;

public abstract class ContenutoAstratto {
    private boolean pending;

    public ContenutoAstratto(boolean pending) {
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
