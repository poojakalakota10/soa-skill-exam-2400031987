package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Address;
import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
  List<Address> findByType(String type);
  
  List<Address> findByName(String name);

}