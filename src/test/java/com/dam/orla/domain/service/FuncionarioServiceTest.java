package com.dam.orla.domain.service;

import com.dam.orla.api.dto.request.FuncionarioRequest;
import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.repository.FuncionarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;


    @Test
    void deveCriarFuncionarioComSucesso() {
        when(funcionarioRepository.save(any())).thenReturn(
            new FuncionarioModel("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000)));

        var funcionario = funcionarioService.criarFuncionario(
            new FuncionarioRequest("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000)));

        assertNotNull(funcionario);
        assertEquals("Douglas Teste", funcionario.nome());
    }

    @Test
    void deveListarFuncionariosComSucesso() {
        when(funcionarioRepository.findAll()).thenReturn(
            java.util.List.of(
                new FuncionarioModel("Douglas Teste First", "12345678900", "teste@email.com", BigDecimal.valueOf(1000)),
                new FuncionarioModel("Douglas Teste Last", "12345678900", "teste@email.com", BigDecimal.valueOf(1000))
                             ));

        var funcionarios = funcionarioService.listarFuncionarios();

        assertNotNull(funcionarios);
        assertEquals(2, funcionarios.size());

        assertEquals("Douglas Teste First", funcionarios.getFirst().nome());
        assertEquals("Douglas Teste Last", funcionarios.getLast().nome());
    }

}