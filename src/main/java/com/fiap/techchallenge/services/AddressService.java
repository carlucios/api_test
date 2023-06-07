package com.fiap.techchallenge.services;

import com.fiap.techchallenge.dto.AddressDTO;
import com.fiap.techchallenge.entities.Address;
import com.fiap.techchallenge.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDTO> findAll() {
        List<AddressDTO> result = addressRepository.findAll().stream().map(x -> new AddressDTO(x)).toList();

        return result;
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}
