package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Address;
import com.klef.soa.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController
{
    @Autowired
    private AddressService service;

    @GetMapping("/")
    public String home()
    {
        return "Welcome";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody Address address)
    {
        Address a = service.addAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

    @GetMapping("/displayall")
    public ResponseEntity<?> displayAll()
    {
        List<Address> addresses = service.displayAll();
        return ResponseEntity.status(HttpStatus.OK).body(addresses);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable Long id)
    {
        Address address = service.displayAddressById(id);

        if(address != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(address);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Address Id not found");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody Address address)
    {
        Address a = service.updateAddress(address);

        if(a != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(a);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id not found to update");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id)
    {
        String message = service.deleteAddressById(id);

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/name/{name}")
public ResponseEntity<?> getAddressByName(@PathVariable String name)
{
    List<Address> addresses = service.findByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(addresses);
}

@GetMapping("/type/{type}")
public ResponseEntity<?> getAddressByType(@PathVariable String type)
{
    List<Address> addresses = service.findByType(type);
    return ResponseEntity.status(HttpStatus.OK).body(addresses);
}

}