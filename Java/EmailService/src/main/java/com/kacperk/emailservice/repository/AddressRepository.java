package com.kacperk.emailservice.repository;

import com.kacperk.emailservice.dtos.AddressDto;
import com.kacperk.emailservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
