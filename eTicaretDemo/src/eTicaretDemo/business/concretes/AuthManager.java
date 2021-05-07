package eTicaretDemo.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaretDemo.business.abstracts.AuthService;
import eTicaretDemo.business.abstracts.CustomerService;
import eTicaretDemo.core.email.abstracts.EmailValidationService;
import eTicaretDemo.core.email.abstracts.GoogleService;
import eTicaretDemo.entities.concretes.Customer;

public class AuthManager implements AuthService{
	
	CustomerService customerService;
	EmailValidationService emailService;
	GoogleService googleService;
	
	public AuthManager(CustomerService customerService,EmailValidationService emailService,GoogleService googleService) {
		// TODO Auto-generated constructor stub
		this.customerService=customerService;
		this.emailService=emailService;
		this.googleService=googleService;
	}
	
	public AuthManager(CustomerService customerService,EmailValidationService emailService) {
		this.customerService=customerService;
		this.emailService=emailService;
	}
	
	@Override
	public void login(String eMail, String pasword) {
		// TODO Auto-generated method stub
		if (customerService.get(eMail).geteMail()==eMail&&customerService.get(eMail).getPassword()==pasword) {
			System.out.println("Sisteme giriþ yapýldý");
		} else {
			System.out.println("Sistemem giriþ yapýlamadý");
		}
	}
	
	@Override
	public void login() {
		googleService.getInfo();
	}

	@Override
	public void register(Customer customer) {
		// TODO Auto-generated method stub
		if (customer.getPassword().trim().length()<6) {
			System.out.println("Parola en az 6 karakter olmalý");
		} else if(!checkIfEmail(customer.geteMail())) {
			System.out.println("E-mail adresiniz doðru formatta deðil");
		} else if(checkIfExistEmail(customer.geteMail())) {
			System.out.println("Bu e-mail daha önce baþkasý tarafýndan alýnmýþ");
		} else if(customer.getfirstName().length()<2||customer.getLastName().length()<2) {
			System.out.println("Ad ve Soyad en az 2 karakterden oluþmalýdýr");
		}else {
			customerService.add(customer);
			emailService.validationToEmail(customer.geteMail());
			System.out.println("Kullanýcý ekleme iþlemi baþarýlý");
		}
	}
	
	@Override
	public void register() {
		googleService.getInfo();
	}
	
	public boolean checkIfEmail(String email){
		Pattern pattern = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	public boolean checkIfExistEmail(String email) {
		for (Customer cus : customerService.getAll()) {
			if (cus.geteMail()==email) {
				return true;
			}
		}
		return false;
	}
	
	

}
