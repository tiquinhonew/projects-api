package com.dam.orla.domain.service;

import com.dam.orla.api.dto.request.ProjetoRequest;
import com.dam.orla.api.dto.response.ProjetoResponse;
import com.dam.orla.core.mapper.ProjetoMapper;
import com.dam.orla.domain.exception.FuncionarioNaoEncontradoException;
import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.model.ProjetoModel;
import com.dam.orla.domain.repository.FuncionarioRepository;
import com.dam.orla.domain.repository.ProjetoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public ProjetoService(final ProjetoRepository projetoRepository, final FuncionarioRepository funcionarioRepository) {
        this.projetoRepository = projetoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public ProjetoResponse criarProjeto(final ProjetoRequest projeto) {
        final Set<FuncionarioModel> funcionarios = new HashSet<>();
        projeto.funcionariosIds().forEach(funcionarioId -> {
            funcionarioRepository.findById(funcionarioId).ifPresentOrElse(funcionarios::add, () -> {
                throw new FuncionarioNaoEncontradoException(funcionarioId);
            });
        });

        final ProjetoModel projetoModel = ProjetoMapper.dtoToEntity(projeto);
        projetoModel.setFuncionarios(funcionarios);
        final ProjetoModel novoProjeto = projetoRepository.save(projetoModel);
        return ProjetoMapper.entityToDto(novoProjeto);
    }

    public List<ProjetoResponse> listarProjetos() {
        final List<ProjetoModel> projetos = projetoRepository.findAll();
        return ProjetoMapper.entityToDto(projetos);
    }
}

