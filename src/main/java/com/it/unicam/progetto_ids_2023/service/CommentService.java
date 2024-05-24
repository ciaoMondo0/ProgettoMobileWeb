package main.java.com.it.unicam.progetto_ids_2023.service;


import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Comment;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.utente.Utente;
import main.java.com.it.unicam.progetto_ids_2023.repository.CommentRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import main.java.com.it.unicam.progetto_ids_2023.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ContenutoRepository contenutoRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ContenutoRepository contenutoRepository, UtenteRepository utenteRepository) {
        this.commentRepository = commentRepository;
        this.contenutoRepository = contenutoRepository;
        this.utenteRepository = utenteRepository;
    }

    public void addComment(Long contenutoId, Long utenteId, String testo) {
        Contenuto contenuto = contenutoRepository.findById(contenutoId)
                .orElseThrow(() -> new IllegalArgumentException("Contenuto non trovato"));
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));

        Comment comment = new Comment();
        comment.setContenuto(contenuto);
        comment.setUtente(utente);
        comment.setTesto(testo);

        contenuto.getComments().add(comment);
        contenutoRepository.save(contenuto);

        commentRepository.save(comment);
    }
}
