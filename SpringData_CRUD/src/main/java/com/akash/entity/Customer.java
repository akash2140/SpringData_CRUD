package com.akash.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.akash.utility.CustomerType;


@Entity
@Table(name="customer")
public class Customer
{
	@Id
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="customer_type")
	@Enumerated(EnumType.STRING)
	private CustomerType  customerType;
	
	
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
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId) && customerType == other.customerType
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", emailId=" + emailId + ", dateOfBirth="
				+ dateOfBirth + ", customerType=" + customerType + "]";
	}
	
	
	
}
