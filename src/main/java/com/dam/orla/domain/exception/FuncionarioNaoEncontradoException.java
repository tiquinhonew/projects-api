package com.dam.orla.domain.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException {


    public FuncionarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public FuncionarioNaoEncontradoException(Long funcionarioId) {
        this(String.format("Não existe um cadastro de funcionário com código %d", funcionarioId));
    }

}
