package com.akash;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.akash.controller.CustomerController;
import com.akash.dto.CustomerDTO;
import com.akash.utility.CustomerType;

@SpringBootApplication
public class SpringDataCrudApplication implements CommandLineRunner {

	public static final Log logger=LogFactory.getLog(SpringDataCrudApplication.class);
	@Autowired
	Environment env;
	
	@Autowired
	CustomerController controller;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		//getAllCustomers();
		//addCustomer();
		//getCustomerById();
	    //updateCustomer();
		deleteCustomer();
	}

	private void deleteCustomer() {
		// TODO Auto-generated method stub
		try {
			Integer customerId=controller.deletCustomer(4);
			logger.info("Customer deleted with customer Id" + customerId);
		}
		catch(Exception e)
		{
			logger.info(env.getProperty(e.getMessage()));
		}
	}

	private void updateCustomer() {
		// TODO Auto-generated method stub
		try {
			CustomerDTO updatedCustomer=controller.updateCustomer(2, "akash@newdomain.com");
			logger.info(updatedCustomer.toString());
		}
		catch(Exception e)
		{
			logger.info(env.getProperty(e.getMessage()));
		}
	}

	private void getCustomerById() {
		try {
			CustomerDTO dto=controller.getCustomerById(3);
			logger.info(dto.toString());
		}
		catch(Exception e)
		{
			logger.info(env.getProperty(e.getMessage()));
		}
	}

	private void addCustomer() {
		// TODO Auto-generated method stub
		try 
		{
			CustomerDTO customer = new CustomerDTO(4, "Harry", "harry@domain.com", LocalDate.now(), CustomerType.GOLD);
			Integer id=controller.addCustomer(customer);
			logger.info("Customer added with id "+id);
		}
		catch(Exception e)
		{
			logger.info(env.getProperty(e.getMessage()));
		}
	}

	private void getAllCustomers() {
		// TODO Auto-generated method stub
		try 
		{
			List<CustomerDTO> dtoList=controller.getAllCustomers();
			dtoList.forEach((dto)->{
				logger.info(dto.toString());
			});
		}
		catch(Exception e)
		{
			logger.info(env.getProperty(e.getMessage()));
		}
	}

	
}
