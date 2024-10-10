package com.dam.orla.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record FuncionarioResponse(
    @Schema(description = "Identificador do funcionário", example = "42")
    Long id,
    @Schema(description = "Nome do funcionário", example = "Douglas Moraes")
    String nome,
    @Schema(description = "CPF do funcionário", example = "123.456.789-00")
    String cpf,
    @Schema(description = "E-mail do funcionário", example = "douglas@email.com")
    String email,
    @Schema(description = "Salário do funcionário", example = "1200.00")
    BigDecimal salario
) {}
