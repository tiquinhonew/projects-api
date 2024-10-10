package com.dam.orla.api.controller;

import com.dam.orla.domain.model.ProjetoModel;
import com.dam.orla.domain.service.ProjetoService;
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
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(final ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projeto) {
        ProjetoModel novoProjeto = projetoService.criarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjeto);
    }

    @GetMapping
    public List<ProjetoModel> listarProjetos() {
        return projetoService.listarProjetos();
    }
}

