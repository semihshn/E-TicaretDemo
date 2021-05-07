package eTicaretDemo.business.abstracts;

import eTicaretDemo.entities.concretes.Customer;

public interface AuthService {
	public void login(String eMail,String pasword);
	public void login();
	public void register(Customer customer);
	public void register();
}
