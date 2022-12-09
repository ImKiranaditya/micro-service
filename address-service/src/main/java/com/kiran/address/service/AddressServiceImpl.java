package com.kiran.address.service;

import com.kiran.address.entities.Address;
import com.kiran.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository repository;

    @Override
    public List<Address> getAll_Address() {
        return repository.findAll();
    }

    @Override
    public Address getAddress(Long addressId) {
        Optional<Address> byId = repository.findById(addressId);
        if (byId.isPresent()) {
            return byId.get();
        }
        return new Address();
    }

    @Override
    public Address addAddress(Address address) {
        return repository.save(address);
    }

    @Override
    public String deleteAddress(Long addressId) {
        repository.deleteById(addressId);
        return "Address Deleted successfully!!";
    }
}
