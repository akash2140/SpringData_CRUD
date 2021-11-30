package com.akash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.akash.dto.CustomerDTO;
import com.akash.exception.CustomerException;
import com.akash.service.CustomerService;


@Controller
public class CustomerController 
{
	@Autowired
	CustomerService serv;
	
	public List<CustomerDTO> getAllCustomers()throws CustomerException
	{
		return serv.getAllCustomers();
	}
	
	public Integer addCustomer(CustomerDTO dto)throws CustomerException
	{
		return serv.addCustomer(dto);
	}
	
	public CustomerDTO getCustomerById(Integer CustomerId) throws CustomerException 
	{
		return serv.getCustomerById(CustomerId);
	}
	
	public CustomerDTO updateCustomer(Integer customerId, String emailId) throws CustomerException 
	{
			return serv.updateCustomer(customerId, emailId);
	}
	
	public Integer deletCustomer(Integer customerId) throws CustomerException{
		return serv.deletCustomer(customerId);
	}
}
