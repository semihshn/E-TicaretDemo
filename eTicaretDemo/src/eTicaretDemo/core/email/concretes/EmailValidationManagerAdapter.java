package eTicaretDemo.core.email.concretes;

import eTicaretDemo.core.email.abstracts.EmailValidationService;
import eTicaretDemo.vEmail.vEmail;

public class EmailValidationManagerAdapter implements EmailValidationService{

	@Override
	public void validationToEmail(String email) {
		vEmail vEmail=new vEmail();
		vEmail.verifyEmail(email);
	}

}
