package eTicaretDemo.dataAccess.abstracts;

import java.util.List;

import eTicaretDemo.entities.concretes.Customer;

public interface CustomerDao {

	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	
	Customer get(String eMail);
	List<Customer> getAll();
}
