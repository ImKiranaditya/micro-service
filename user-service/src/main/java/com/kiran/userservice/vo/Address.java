package com.kiran.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long addressId;
    private String Street1;
    private String Street2;
    private String city;
    private String pinCode;
}
