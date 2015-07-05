package com.loginpage.service;

import com.loginpage.dao.ILoginPageDao;
import com.loginpage.dao.LoginPageDaoImpl;
import com.loginpage.model.LoginPage;

public class LoginPageServiceImpl implements ILoginPageService {
	ILoginPageDao loginPageDaoObject = new LoginPageDaoImpl();

	public boolean addUser(LoginPage object) {

		boolean status = false;
		if (object.getUserName() != null && object.getPassword() != null) {
			status = loginPageDaoObject.addUser(object);
		}
		return status;
	}

	public boolean checkValidation(LoginPage object) {
		boolean status = false;
		if (object.getUserName() != null && object.getPassword() != null) {
			status = loginPageDaoObject.addUser(object);
		}
		return status;
	}

}
