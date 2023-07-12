package com.fiap.techchallenge.controllers;

import com.fiap.techchallenge.dto.ColaboradorDTO;
import com.fiap.techchallenge.services.ColaboradorService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<ColaboradorDTO> findAll() {
        List<ColaboradorDTO> result = colaboradorService.findAll();

        return result;
    }

    @GetMapping(value = "/{:id}")
    public ColaboradorDTO findById(Long id) {
        ColaboradorDTO dto = colaboradorService.findById(id);

        return dto;
    }

    @PostMapping
    public ResponseEntity<?> newColaboradorDTO(@RequestBody ColaboradorDTO colaboradorDTO) {
        Set<ConstraintViolation<ColaboradorDTO>> violacoes = 
                Validation.buildDefaultValidatorFactory().getValidator().validate(colaboradorDTO);
        Map<Path, String> violacoesToMap = violacoes.stream().collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }

        colaboradorService.saveColaborador(colaboradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço cadastrado com sucesso!");
    }
}
