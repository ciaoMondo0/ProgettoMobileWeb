package com.it.unicam.progetto_ids_2023.service;

import com.it.unicam.progetto_ids_2023.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContenutoService {

    private ContenutoRepository contenutoRepository;

    @Autowired
    public ContenutoService(ContenutoRepository contenutoRepository) {
        this.contenutoRepository = contenutoRepository;
    }
}
