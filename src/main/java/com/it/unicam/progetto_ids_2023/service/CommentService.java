package com.it.unicam.progetto_ids_2023.service;


import com.it.unicam.progetto_ids_2023.model.contenuto.Comment;
import com.it.unicam.progetto_ids_2023.model.contenuto.ContenutoBase;
import com.it.unicam.progetto_ids_2023.model.utente.Utente;
import com.it.unicam.progetto_ids_2023.repository.CommentRepository;
import com.it.unicam.progetto_ids_2023.repository.ContenutoBaseRepository;
import com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ContenutoBaseRepository contenutoBaseRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ContenutoBaseRepository contenutoBaseRepository, UtenteRepository utenteRepository) {
        this.commentRepository = commentRepository;
        this.contenutoBaseRepository = contenutoBaseRepository;
        this.utenteRepository = utenteRepository;
    }

    public void addComment(Long contenutoId, Long utenteId, String testo) {
        ContenutoBase contenuto = contenutoBaseRepository.findById(contenutoId)
                .orElseThrow(() -> new IllegalArgumentException("Contenuto non trovato"));
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));

        Comment comment = new Comment();
        comment.setContenuto(contenuto);
        comment.setUtente(utente);
        comment.setTesto(testo);

        commentRepository.save(comment);
    }
}
