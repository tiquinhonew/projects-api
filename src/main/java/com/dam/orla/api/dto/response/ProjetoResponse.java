package com.dam.orla.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

public record ProjetoResponse(
    @Schema(description = "Identificador do projeto", example = "42", name = "projeto_id")
    Long projetoId,
    @Schema(description = "Nome do projeto", example = "Projeto de Investimentos")
    String nome,
    @Schema(description = "Data de criação do projeto", example = "2022-12-31", name = "data_criacao")
    LocalDate dataCriacao,
    @Schema(description = "Lista de funcionários alocados no projeto")
    List<FuncionarioResponse> funcionarios
) {

}
