package com.codedifferently.SpringBootCRUDDemo.service;

import com.codedifferently.SpringBootCRUDDemo.model.Address;

import java.util.List;

public interface AddressService {

    Address createAddress(Address address);

    Address updateAddress(Address address);

    List<Address> getAllAddresses();

    Address getAddressById(long addressId);

    void deleteAddress(long addressId);
}
