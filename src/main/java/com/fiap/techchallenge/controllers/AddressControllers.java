package com.fiap.techchallenge.controllers;

import com.fiap.techchallenge.dto.AddressDTO;
import com.fiap.techchallenge.entities.Address;
import com.fiap.techchallenge.services.AddressService;
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
@RequestMapping(value = "/address")
public class AddressControllers {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressDTO> findAll() {
        List<AddressDTO> result = addressService.findAll();

        return result;
    }

    @PostMapping
    public ResponseEntity newAddressDTO(@RequestBody AddressDTO addressDTO) {
        Set<ConstraintViolation<AddressDTO>> violacoes = 
                Validation.buildDefaultValidatorFactory().getValidator().validate(addressDTO);
        Map<Path, String> violacoesToMap = violacoes.stream().collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }

        Address address = addressDTO.mapToAddress();
        addressService.saveAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço cadastrado com sucesso!");
    }
}
