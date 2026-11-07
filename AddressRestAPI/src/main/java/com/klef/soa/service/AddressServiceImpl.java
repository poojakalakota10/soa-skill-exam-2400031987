package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Address;
import com.klef.soa.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService
{
    @Autowired
    private AddressRepository repo;

    @Override
    public Address addAddress(Address address)
    {
        return repo.save(address);
    }

    @Override
    public Address updateAddress(Address address)
    {
        Optional<Address> optional = repo.findById(address.getId());

        if(optional.isPresent())
        {
            Address a = optional.get();

            a.setName(address.getName());
            a.setLocation(address.getLocation());
            a.setStatus(address.isStatus());
            a.setType(address.getType());

            return repo.save(a);
        }
        else
        {
            return null;
        }
    }

    @Override
    public String deleteAddressById(Long id)
    {
        boolean status = repo.existsById(id);

        if(status)
        {
            repo.deleteById(id);
            return "Address record deleted successfully";
        }
        else
        {
            return "Address Id not found to delete";
        }
    }

    @Override
    public List<Address> displayAll()
    {
        return repo.findAll();
    }

    @Override
    public Address displayAddressById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Address> findByType(String type)
    {
        return repo.findByType(type);
    }

    @Override
    public List<Address> findByName(String name)
    {
        return repo.findByName(name);
    }
}