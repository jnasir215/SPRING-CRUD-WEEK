package com.codedifferently.SpringBootCRUDDemo.service;

import com.codedifferently.SpringBootCRUDDemo.model.Address;
import com.codedifferently.SpringBootCRUDDemo.repository.AddressRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> addressDb = this.addressRepository.findById(address.getId());

        if(addressDb.isPresent()) {
            Address addressUpdate = addressDb.get();
            addressUpdate.setId(address.getId());
            addressUpdate.setStreet(address.getStreet());
            addressUpdate.setNumber(address.getNumber());
            addressUpdate.setState(address.getState());
            addressRepository.save(addressUpdate);
            return addressUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + address.getId());
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long addressId) {
        Optional<Address> addressDb = this.addressRepository.findById(addressId);

        if(addressDb.isPresent()) {
            return addressDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + addressId);
        }
    }

    @Override
    public void deleteAddress(long addressId) {
        Optional<Address> addressDb = this.addressRepository.findById(addressId);

        if(addressDb.isPresent()) {
            this.addressRepository.delete(addressDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + addressId);
        }
    }
}
