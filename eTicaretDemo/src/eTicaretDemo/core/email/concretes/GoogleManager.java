package eTicaretDemo.core.email.concretes;

import eTicaretDemo.core.email.abstracts.GoogleService;
import eTicaretDemo.googleService.userInfo;

public class GoogleManager implements GoogleService{

	@Override
	public void getInfo() {
		userInfo usr=new userInfo();
		usr.getUser();
	}
	
}
