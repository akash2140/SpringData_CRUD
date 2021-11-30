package com.akash.repository;

import org.springframework.data.repository.CrudRepository;

import com.akash.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	
}
