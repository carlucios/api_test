package com.fiap.techchallenge.repositories;

import com.fiap.techchallenge.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
