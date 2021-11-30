package com.akash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.dto.CustomerDTO;
import com.akash.entity.Customer;
import com.akash.exception.CustomerException;
import com.akash.repository.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerRepository repo;

	@Override
	public List<CustomerDTO> getAllCustomers() throws CustomerException
	{
		// TODO Auto-generated method stub
		Iterable<Customer> customerIter=repo.findAll();
		List<Customer> customerList=new ArrayList<Customer>();
		customerIter.forEach(customerList::add);
		List<CustomerDTO> dtoList=new ArrayList<>();
		customerList.forEach((customer)->{
			CustomerDTO dto=new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getEmailId(), customer.getDateOfBirth(), customer.getCustomerType());
			dtoList.add(dto);
		});
		if(dtoList.size()==0)
		{
			throw new CustomerException("NO_CUSTOMER_EXIST");
		}
		return dtoList;
	}

	@Override
	public Integer addCustomer(CustomerDTO dto) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> exist=repo.findById(dto.getCustomerId());
		if(exist.isPresent())
		{
			throw new CustomerException("CUSTOMER_ALREADY_EXISTS");
		}
		Customer customer=new Customer();
		customer.setCustomerId(dto.getCustomerId());
		customer.setCustomerType(dto.getCustomerType());
		customer.setDateOfBirth(dto.getDateOfBirth());
		customer.setEmailId(dto.getEmailId());
		customer.setName(dto.getName());
		repo.save(customer);
		return customer.getCustomerId();
	}

	@Override
	public CustomerDTO getCustomerById(Integer CustomerId) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> optional=repo.findById(CustomerId);
		Customer customer=optional.orElseThrow(()->new CustomerException("NO_CUSTOMER_EXIST"));
		CustomerDTO dto=new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getEmailId(),customer.getDateOfBirth(), customer.getCustomerType());
		return dto;
	}

	@Override
	public CustomerDTO updateCustomer(Integer customerId, String emailId) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> optional = repo.findById(customerId);
		Customer customer=optional.orElseThrow(()->new CustomerException("NO_CUSTOMER_EXISTS"));
		customer.setEmailId(emailId);
		CustomerDTO dto=new CustomerDTO(customerId, customer.getName(), customer.getEmailId(), customer.getDateOfBirth(), customer.getCustomerType());
		return dto;
	}

	@Override
	public Integer deletCustomer(Integer customerId) throws CustomerException
	{
		// TODO Auto-generated method stub
		Optional<Customer> optional=repo.findById(customerId);
		Customer customer=optional.orElseThrow(()->new CustomerException("NO_CUSTOMER_EXIST"));
		repo.deleteById(customer.getCustomerId());
		return customerId;
	}
	
}
