package com.kiran.address.service;

import com.kiran.address.entities.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll_Address();

    Address getAddress(Long addressId);

    Address addAddress(Address address);

    String deleteAddress(Long addressId);
}
