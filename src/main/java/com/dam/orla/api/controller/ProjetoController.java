package com.dam.orla.api.controller;

import com.dam.orla.api.dto.request.ProjetoRequest;
import com.dam.orla.api.dto.response.ProjetoResponse;
import com.dam.orla.domain.service.ProjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@Tag(name = "Projeto Controller", description = "Endpoints para gerenciamento de projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(final ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    @Operation(summary = "Criar um novo projeto", description = "Este endpoint cria um novo projeto com os funcionários fornecidos")
    @ApiResponse(responseCode = "201", description = "Projeto criado com sucesso")
    public ResponseEntity<ProjetoResponse> criarProjeto(@RequestBody ProjetoRequest projeto) {
        var novoProjeto = projetoService.criarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjeto);
    }

    @GetMapping
    @Operation(summary = "Listar todos os projetos", description = "Este endpoint retorna todos os projetos")
    @ApiResponse(responseCode = "200", description = "Projetos retornados com sucesso")
    public List<ProjetoResponse> listarProjetos() {
        return projetoService.listarProjetos();
    }
}

