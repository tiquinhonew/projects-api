package com.dam.orla.api.controller;

import com.dam.orla.api.dto.request.ProjetoRequest;
import com.dam.orla.api.dto.response.FuncionarioResponse;
import com.dam.orla.api.dto.response.ProjetoResponse;
import com.dam.orla.domain.service.ProjetoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjetoControllerTest {

    @Mock
    private ProjetoService projetoService;

    @InjectMocks
    private ProjetoController projetoController;

    @Test
    void deveCriarProjeto() {
        when(projetoService.criarProjeto(any(ProjetoRequest.class))).thenReturn(
            new ProjetoResponse(1L, "Projeto Teste", LocalDate.now(), List.of(
                new FuncionarioResponse(1L, "Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000)))
            ));

        var projetoRequest = new ProjetoRequest("Projeto Teste", LocalDate.now(), List.of(1L));
        var projetoResponse = projetoController.criarProjeto(projetoRequest);

        assertNotNull(projetoResponse);
        assertEquals("Projeto Teste", Objects.requireNonNull(projetoResponse.getBody()).nome());
    }

    @Test
    void deveListarProjetos() {
        when(projetoService.listarProjetos()).thenReturn(List.of(
            new ProjetoResponse(1L, "Projeto Teste", LocalDate.now(), List.of(
                new FuncionarioResponse(1L, "Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000)))
            )));

        var projetos = projetoController.listarProjetos();

        assertNotNull(projetos);
        assertEquals(1, projetos.size());
    }

}