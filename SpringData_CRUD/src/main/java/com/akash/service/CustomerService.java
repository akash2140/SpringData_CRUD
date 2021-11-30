package com.akash.service;

import java.util.List;

import com.akash.dto.CustomerDTO;
import com.akash.exception.CustomerException;

public interface CustomerService 
{
	public List<CustomerDTO> getAllCustomers()throws CustomerException;
	public Integer addCustomer(CustomerDTO dto)throws CustomerException;
	public CustomerDTO getCustomerById(Integer CustomerId)throws CustomerException;
	public CustomerDTO updateCustomer(Integer customerId,String emailId)throws CustomerException;
	public Integer deletCustomer(Integer customerId)throws CustomerException;
}
