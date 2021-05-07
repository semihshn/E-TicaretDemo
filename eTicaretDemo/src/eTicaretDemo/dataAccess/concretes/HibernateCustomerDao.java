package eTicaretDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretDemo.dataAccess.abstracts.CustomerDao;
import eTicaretDemo.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {
	
	List<Customer> customerList=new ArrayList<Customer>();

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Hibernate ile eklendi "+ customer.getfirstName());
		customerList.add(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Do�rulama linki t�kland��� i�in �yenin status bilgisi true yap�ld�");
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Kullan�c� silindi");
	}

	@Override
	public Customer get(String eMail) {
		// TODO Auto-generated method stub
		for (Customer customer : customerList) {
			if (customer.geteMail()==eMail) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerList;
	}

}
