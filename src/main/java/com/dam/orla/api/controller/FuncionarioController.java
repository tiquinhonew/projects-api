package com.dam.orla.api.controller;

import com.dam.orla.api.dto.request.FuncionarioRequest;
import com.dam.orla.api.dto.response.FuncionarioResponse;
import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.service.FuncionarioService;
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
@RequestMapping("/funcionarios")
@Tag(name = "Funcionario Controller", description = "Endpoints para gerenciamento de funcionários")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(final FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @Operation(summary = "Criar um novo funcionário", description = "Este endpoint cria um novo funcionário")
    @ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso")
    public ResponseEntity<FuncionarioResponse> criarFuncionario(@RequestBody FuncionarioRequest funcionario) {
        var novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @GetMapping
    @Operation(summary = "Listar todos os funcionários", description = "Este endpoint retorna todos os funcionários")
    @ApiResponse(responseCode = "200", description = "Funcionários retornados com sucesso")
    public List<FuncionarioResponse> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }
}

