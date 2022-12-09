package com.kiran.userservice.external.service;

import com.kiran.userservice.vo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ADDRESS-SERVICE", url = "http://localhost:8082/api/addresses")
public interface AddressServiceExternal {

    @GetMapping("/{addressId}")
    Address getAddressById(@PathVariable Long addressId);
}
