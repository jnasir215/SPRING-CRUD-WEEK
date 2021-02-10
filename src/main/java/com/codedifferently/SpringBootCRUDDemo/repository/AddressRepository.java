package com.codedifferently.SpringBootCRUDDemo.repository;

import com.codedifferently.SpringBootCRUDDemo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
