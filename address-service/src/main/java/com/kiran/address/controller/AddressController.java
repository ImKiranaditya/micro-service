package com.kiran.address.controller;

import com.kiran.address.entities.Address;
import com.kiran.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    List<Address> findAllAddress() {
        return addressService.getAll_Address();
    }

    @PostMapping
    Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/{addressId}")
    Address getAddressById(@PathVariable Long addressId) {
        return addressService.getAddress(addressId);
    }

    @DeleteMapping("/{addressId}")
    String deleteAddressById(@PathVariable Long addressId) {
        return addressService.deleteAddress(addressId);
    }
}
