package com.dam.orla.api.controller;

import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.service.FuncionarioService;
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
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(final FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> criarFuncionario(@RequestBody FuncionarioModel funcionario) {
        FuncionarioModel novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @GetMapping
    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }
}

