package com.infoobjects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.infoobjects.model.Customer;
import com.infoobjects.repositories.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public void createCustomerRecord(Customer customerObject) {
		customerRepository.save(customerObject);
	}

	public List<Customer> getAllRecords() {
		System.out.println("hello 0");
		List<Customer> list =  (List<Customer>) customerRepository.findAll();
		System.out.println("hello 1");
		System.out.println(list);
		return list;
	}

	public void deleteCustomerRecord(int id) throws EmptyResultDataAccessException{
			customerRepository.deleteById(id);
	}
}
