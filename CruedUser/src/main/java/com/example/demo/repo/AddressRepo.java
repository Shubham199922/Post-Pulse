package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Address;

public interface AddressRepo extends CrudRepository<Address, Integer> {

}
