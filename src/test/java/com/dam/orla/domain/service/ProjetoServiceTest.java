package com.dam.orla.domain.service;

import com.dam.orla.api.dto.request.ProjetoRequest;
import com.dam.orla.domain.exception.EntidadeNaoEncontradaException;
import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.model.ProjetoModel;
import com.dam.orla.domain.repository.FuncionarioRepository;
import com.dam.orla.domain.repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private ProjetoService projetoService;


    @Test
    void deveCriarProjetoComSucesso() {
        ProjetoModel projeto = new ProjetoModel();
        projeto.setNome("Projeto Teste");
        projeto.setDataCriacao(LocalDate.now());

        ProjetoRequest projetoModel = new ProjetoRequest("Projeto", LocalDate.now(), List.of(1L, 2L));

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(new FuncionarioModel("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000))));
        when(funcionarioRepository.findById(2L)).thenReturn(Optional.of(new FuncionarioModel("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000))));
        when(projetoRepository.save(any(ProjetoModel.class))).thenReturn(projeto);


        var projetoCriado = projetoService.criarProjeto(projetoModel);

        assertNotNull(projetoCriado);
        assertEquals("Projeto Teste", projetoCriado.nome());
    }

    @Test
    void deveLancarExcecaoAoCriarProjetoComFuncionarioInexistente() {
        ProjetoRequest projetoModel = new ProjetoRequest("Projeto", LocalDate.now(), List.of(1L, 2L));

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> projetoService.criarProjeto(projetoModel));
    }

    @Test
    void deveListarProjetosComSucesso() {
        ProjetoModel projeto = new ProjetoModel();
        projeto.setNome("Projeto Teste");
        projeto.setDataCriacao(LocalDate.now());

        when(projetoRepository.findAll()).thenReturn(List.of(projeto));

        var projetos = projetoService.listarProjetos();

        assertNotNull(projetos);
        assertEquals(1, projetos.size());
        assertEquals("Projeto Teste", projetos.getFirst().nome());
    }

}