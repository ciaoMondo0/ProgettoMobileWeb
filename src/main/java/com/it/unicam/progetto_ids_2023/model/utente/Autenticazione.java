package com.it.unicam.progetto_ids_2023.model.utente;


// Classe per gestire l'autenticazione e l'autorizzazione
class AutenticazioneEAutorizzazione {
    private Utente utenteRegistrato;

    public AutenticazioneEAutorizzazione() {
        utenteRegistrato = null;
    }

    // Metodo per eseguire il login
    public void login(String username, Ruolo ruolo) {
        utenteRegistrato = new Utente(utenteRegistrato.getNome(), utenteRegistrato.getEmail());
        System.out.println("Utente " + username + " loggato con ruolo " + ruolo);
    }

    // Metodo per eseguire il logout
    public void logout() {
        utenteRegistrato = null;
        System.out.println("Utente disconnesso.");
    }

    // Metodo per controllare se l'utente loggato ha il ruolo richiesto
    public boolean checkRole(Ruolo ruoloRichiesto) {
        return utenteRegistrato != null && utenteRegistrato.getRuolo() == ruoloRichiesto;
    }
}



