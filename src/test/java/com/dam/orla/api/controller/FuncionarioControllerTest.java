package com.dam.orla.api.controller;

import com.dam.orla.api.dto.request.FuncionarioRequest;
import com.dam.orla.api.dto.response.FuncionarioResponse;
import com.dam.orla.domain.service.FuncionarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FuncionarioControllerTest {

    @Mock
    private FuncionarioService funcionarioService;

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Test
    void deveCriarFuncionarioComSucesso() {
        when(funcionarioService.criarFuncionario(any())).thenReturn(
            new FuncionarioResponse(1L, "Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000))
        );

        var funcionarioRequest = new FuncionarioRequest("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000));
        var funcionarioResponse = funcionarioController.criarFuncionario(funcionarioRequest);

        assertNotNull(funcionarioResponse);
        assertEquals("Douglas Teste", Objects.requireNonNull(funcionarioResponse.getBody()).nome());
    }

    @Test
    void deveListarFuncionariosComSucesso() {
        when(funcionarioService.listarFuncionarios()).thenReturn(
            List.of(new FuncionarioResponse(1L, "Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000))));

        var funcionarios = funcionarioController.listarFuncionarios();

        assertNotNull(funcionarios);
        assertEquals(1, funcionarios.size());
    }

}