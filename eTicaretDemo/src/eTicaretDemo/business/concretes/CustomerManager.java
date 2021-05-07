package eTicaretDemo.business.concretes;

import java.util.List;

import eTicaretDemo.business.abstracts.CustomerService;
import eTicaretDemo.dataAccess.concretes.HibernateCustomerDao;
import eTicaretDemo.entities.concretes.Customer;

public class CustomerManager implements CustomerService{
	
	HibernateCustomerDao customerDao;

	
	public CustomerManager(HibernateCustomerDao customerDao) {
		this.customerDao=customerDao;
	}

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.add(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.delete(customer);
	}

	@Override
	public Customer get(String eMail) {
		// TODO Auto-generated method stub
		if(customerDao.get(eMail)!=null) {
			return customerDao.get(eMail);
		}
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerDao.getAll();
	}

}
