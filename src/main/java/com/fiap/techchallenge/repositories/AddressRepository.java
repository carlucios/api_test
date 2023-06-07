package com.fiap.techchallenge.repositories;

import com.fiap.techchallenge.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
