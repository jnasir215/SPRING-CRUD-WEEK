package com.codedifferently.SpringBootCRUDDemo.controller;

import com.codedifferently.SpringBootCRUDDemo.model.Address;
import com.codedifferently.SpringBootCRUDDemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long id) {
        return ResponseEntity.ok().body(addressService.getAddressById(id));
    }

    @PostMapping("/addresses")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.ok().body(this.addressService.createAddress(address));
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address address) {
        return ResponseEntity.ok().body(this.addressService.updateAddress(address));
    }

    public HttpStatus deleteAddress(@PathVariable long id) {
        this.addressService.deleteAddress(id);
        return HttpStatus.OK;
    }
}
