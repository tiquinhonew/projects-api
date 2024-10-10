package com.dam.orla.core.mapper;

import com.dam.orla.api.dto.request.FuncionarioRequest;
import com.dam.orla.api.dto.response.FuncionarioResponse;
import com.dam.orla.domain.model.FuncionarioModel;

import java.util.List;

public class FuncionarioMapper {
    private FuncionarioMapper() {
    }

    public static FuncionarioResponse entityToDto(FuncionarioModel funcionarioModel) {
        return new FuncionarioResponse(
            funcionarioModel.getId(),
            funcionarioModel.getNome(),
            funcionarioModel.getCpf(),
            funcionarioModel.getEmail(),
            funcionarioModel.getSalario());
    }

    public static List<FuncionarioResponse> entityToDto(List<FuncionarioModel> funcionarioModel) {
        return funcionarioModel
            .stream()
            .map(FuncionarioMapper::entityToDto)
            .toList();
    }

    public static FuncionarioModel dtoToEntity(FuncionarioRequest funcionarioRequest) {
        return new FuncionarioModel(
            funcionarioRequest.nome(),
            funcionarioRequest.cpf(),
            funcionarioRequest.email(),
            funcionarioRequest.salario());
    }

}
