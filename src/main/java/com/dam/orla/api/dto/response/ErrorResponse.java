package com.dam.orla.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record ErrorResponse(
    @Schema(description = "Código do erro", example = "400")
    LocalDateTime timestamp,
    @Schema(description = "Código do erro", example = "400")
    String message,
    @Schema(description = "Detalhes do erro", example = "Erro ao processar a requisição")
    String details
) {}

