package eTicaretDemo.business.abstracts;

import java.util.List;

import eTicaretDemo.entities.concretes.Customer;

public interface CustomerService {
	 void add(Customer customer);
	 void update(Customer customer);
	 void delete(Customer customer);
	
	 Customer get(String eMail);
	 List<Customer> getAll();

}
