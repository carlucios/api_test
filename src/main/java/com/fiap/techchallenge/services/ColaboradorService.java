package com.fiap.techchallenge.services;

import com.fiap.techchallenge.dto.ColaboradorDTO;
import com.fiap.techchallenge.entities.Colaborador;
import com.fiap.techchallenge.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Transactional(readOnly = true)
    public List<ColaboradorDTO> findAll() {
        List<ColaboradorDTO> result = colaboradorRepository.findAll().stream().map(x -> new ColaboradorDTO(x)).toList();
        return result;
    }

    @Transactional(readOnly = true)
    public ColaboradorDTO findById(Long id) {
        Optional<Colaborador> result = colaboradorRepository.findById(id);
        Colaborador colaborador = result.get();
        ColaboradorDTO dto = new ColaboradorDTO(colaborador);
        return dto;
    }

    public ColaboradorDTO saveColaborador(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = colaboradorDTO.mapToColaborador();
        colaboradorRepository.save(colaborador);
        return colaboradorDTO;
    }
}
