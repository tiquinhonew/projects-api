package com.dam.orla.domain.service;

import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(final FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioModel criarFuncionario(final FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }
}

