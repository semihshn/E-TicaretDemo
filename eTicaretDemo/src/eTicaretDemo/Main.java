package eTicaretDemo;

import eTicaretDemo.business.abstracts.AuthService;
import eTicaretDemo.business.abstracts.CustomerService;
import eTicaretDemo.business.concretes.AuthManager;
import eTicaretDemo.business.concretes.CustomerManager;
import eTicaretDemo.core.email.abstracts.EmailValidationService;
import eTicaretDemo.core.email.concretes.EmailValidationManagerAdapter;
import eTicaretDemo.core.email.concretes.GoogleManager;
import eTicaretDemo.dataAccess.concretes.HibernateCustomerDao;
import eTicaretDemo.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customer=new Customer("Semih","Þahan","s.semih.sahan@hotmail.com","123456");
		Customer customer2=new Customer("Ahmet","Asiltürk","asil_turk123@hotmail.com","123456");
		
		AuthService authService=new AuthManager(new CustomerManager(new HibernateCustomerDao()),
				new EmailValidationManagerAdapter());
		
		AuthService authServiceGoogle=new AuthManager(new CustomerManager(new HibernateCustomerDao()),
				new EmailValidationManagerAdapter(),
				new GoogleManager());
		
		CustomerService customerService=new CustomerManager(new HibernateCustomerDao());
		
		authService.register(customer);
		authService.register(customer2);
		customerService.update(customer2);
		authServiceGoogle.register();
		
		for (Customer cus : customerService.getAll()) {
			System.out.println(cus.getfirstName());
		}
		
		

	}

}
