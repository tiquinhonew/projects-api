package com.dam.orla.domain.service;

import com.dam.orla.domain.model.ProjetoModel;
import com.dam.orla.domain.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(final ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public ProjetoModel criarProjeto(final ProjetoModel projeto) {
        return projetoRepository.save(projeto);
    }

    public List<ProjetoModel> listarProjetos() {
        return projetoRepository.findAll();
    }
}

