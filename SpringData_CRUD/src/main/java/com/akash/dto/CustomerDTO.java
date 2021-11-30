package com.akash.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.akash.utility.CustomerType;

public class CustomerDTO 
{
	private Integer customerId;
	private String name;
	private String emailId;
	private LocalDate dateOfBirth;
	private CustomerType  customerType;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(customerId, customerType, dateOfBirth, emailId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(customerId, other.customerId) && customerType == other.customerType
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(name, other.name);
	}
	public CustomerDTO(Integer customerId, String name, String emailId, LocalDate dateOfBirth,
			CustomerType customerType) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.customerType = customerType;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", emailId=" + emailId + ", dateOfBirth="
				+ dateOfBirth + ", customerType=" + customerType + "]";
	}
	
	
}
