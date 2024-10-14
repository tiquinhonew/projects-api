package com.dam.orla.domain.service;

import com.dam.orla.api.dto.request.FuncionarioRequest;
import com.dam.orla.api.dto.response.FuncionarioResponse;
import com.dam.orla.core.mapper.FuncionarioMapper;
import com.dam.orla.domain.exception.FuncionarioEmUsoException;
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

    public FuncionarioResponse criarFuncionario(final FuncionarioRequest funcionario) {
        final FuncionarioModel funcionarioModel = FuncionarioMapper.dtoToEntity(funcionario);
        ifPresentThrowException(funcionario.cpf(), funcionario.email());
        final FuncionarioModel novoFuncionario = funcionarioRepository.save(funcionarioModel);
        return FuncionarioMapper.entityToDto(novoFuncionario);
    }

    public List<FuncionarioResponse> listarFuncionarios() {
        final List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        return FuncionarioMapper.entityToDto(funcionarios);
    }

    private void ifPresentThrowException(final String cpf, final String email) {
        if (funcionarioRepository.existsByCpfOrEmail(cpf, email)) {
            throw new FuncionarioEmUsoException("Já existe um funcionário cadastrado com o CPF ou e-mail informado");
        }
    }

}

