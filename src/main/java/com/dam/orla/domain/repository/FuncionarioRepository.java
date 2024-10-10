package com.dam.orla.domain.repository;

import com.dam.orla.domain.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}

