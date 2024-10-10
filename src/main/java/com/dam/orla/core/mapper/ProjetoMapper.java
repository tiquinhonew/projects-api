package com.dam.orla.core.mapper;

import com.dam.orla.api.dto.request.ProjetoRequest;
import com.dam.orla.api.dto.response.ProjetoResponse;
import com.dam.orla.domain.model.ProjetoModel;

import java.util.List;

public class ProjetoMapper {
    private ProjetoMapper() {
    }

    public static ProjetoResponse entityToDto(ProjetoModel projetoModel) {
        return new ProjetoResponse(
            projetoModel.getId(),
            projetoModel.getNome(),
            projetoModel.getDataCriacao(),
            projetoModel.getFuncionarios()
                .stream()
                .map(FuncionarioMapper::entityToDto)
                .toList());
    }

    public static List<ProjetoResponse> entityToDto(List<ProjetoModel> projetoModel) {
        return projetoModel.stream().map(ProjetoMapper::entityToDto).toList();
    }

    public static ProjetoModel dtoToEntity(ProjetoRequest projetoRequest) {
        return new ProjetoModel(
            projetoRequest.nome(),
            projetoRequest.dataCriacao());
    }
}
