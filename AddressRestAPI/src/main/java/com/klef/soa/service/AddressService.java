package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Address;

public interface AddressService
{
    Address addAddress(Address address);
    Address updateAddress(Address address);
    String deleteAddressById(Long id);
    List<Address> displayAll();
    Address displayAddressById(Long id);
    List<Address> findByType(String type);
    List<Address> findByName(String name);
}