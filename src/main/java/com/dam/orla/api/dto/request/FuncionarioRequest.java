package com.dam.orla.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record FuncionarioRequest(
    @Schema(description = "Nome do funcionário", example = "Douglas Moraes")
    String nome,
    @Schema(description = "CPF do funcionário", example = "123.456.789-00")
    String cpf,
    @Schema(description = "Email do funcionário", example = "douglas@email.com")
    String email,
    @Schema(description = "Salário do funcionário", example = "5000.00")
    BigDecimal salario
) {}
