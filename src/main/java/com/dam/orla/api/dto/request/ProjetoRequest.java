package com.dam.orla.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

public record ProjetoRequest(
    @Schema(description = "Nome do projeto", example = "Projeto cartão de credito")
    String nome,
    @Schema(description = "Data de criação do projeto", example = "2023-12-31", name = "data_criacao")
    LocalDate dataCriacao,
    @Schema(description = "Lista de ids dos funcionários que participam do projeto", example = "[42, 43, 44]", name = "funcionarios_ids")
    List<Long> funcionariosIds
) {

}
