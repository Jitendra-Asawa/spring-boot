package com.infoobjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoobjects.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
