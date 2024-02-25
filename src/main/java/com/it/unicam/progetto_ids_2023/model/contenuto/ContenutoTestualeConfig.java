package com.it.unicam.progetto_ids_2023.model.contenuto;

import com.it.unicam.progetto_ids_2023.repository.ContenutoBaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class ContenutoTestualeConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            ContenutoBaseRepository repository) {
        return args -> {
         ContenutoBase contenutoTestuale = new ContenutoBase(
                    "Ciao", true);{
                        repository.saveAll(List.of(contenutoTestuale));

            }
        };
    }

}
