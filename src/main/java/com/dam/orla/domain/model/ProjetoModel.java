package com.dam.orla.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_projeto")
public class ProjetoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToMany
    @JoinTable(
        name = "tb_projeto_funcionario",
        joinColumns = @JoinColumn(name = "projeto_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private Set<FuncionarioModel> funcionarios = new HashSet<>();

    public ProjetoModel() {
    }

    public ProjetoModel(final String nome, final LocalDate dataCriacao) {
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(final LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Set<FuncionarioModel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(final Set<FuncionarioModel> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
