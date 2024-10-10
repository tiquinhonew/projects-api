package com.dam.orla.domain.repository;

import com.dam.orla.domain.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

    Optional<FuncionarioModel> findByCpf(String cpf);

    Optional<FuncionarioModel> findByEmail(String email);

}

