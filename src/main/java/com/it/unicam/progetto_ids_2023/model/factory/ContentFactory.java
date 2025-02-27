package main.java.com.it.unicam.progetto_ids_2023.model.factory;

import main.java.com.it.unicam.progetto_ids_2023.dto.ContenutoDTO;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.*;
import main.java.com.it.unicam.progetto_ids_2023.repository.ComuneRepository;
import org.springframework.stereotype.Service;

@Service
public class ContentFactory implements ContenutoFactory {


    @Override
    public Contenuto createContenuto(ContenutoDTO contenutoDTO) {
        if (contenutoDTO == null) {
            throw new IllegalArgumentException("Il DTO del contenuto non può essere nullo");
        }

        return switch (contenutoDTO.tipo()) {
            case TESTUALE -> createContenutoTestuale(contenutoDTO);
            case MULTIMEDIALE -> createContenutoMultimediale(contenutoDTO);
            default -> throw new IllegalArgumentException("Tipo di contenuto non supportato");
        };
    }

    private ContenutoTestuale createContenutoTestuale(ContenutoDTO contenutoDTO) {
        return new ContenutoTestuale(
                contenutoDTO.testo(),
                ContenutiStati.PENDING,
                contenutoDTO.nomeContenuto()
        );
    }

    private ContenutoMultimediale createContenutoMultimediale(ContenutoDTO contenutoDTO) {
        return new ContenutoMultimediale(
                contenutoDTO.file(),
                ContenutiStati.PENDING,
                contenutoDTO.nomeContenuto()
        );
    }

    public ContenutoTestuale createContenutoContest(ContenutoDTO contenutoDTO) {
        return new ContenutoTestuale(
                contenutoDTO.testo(),
                ContenutiStati.ACCETTATO,
                contenutoDTO.nomeContenuto()
        );
    }
}
