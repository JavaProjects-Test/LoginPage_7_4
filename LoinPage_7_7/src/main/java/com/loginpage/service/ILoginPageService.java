package com.loginpage.service;

import com.loginpage.model.LoginPage;

public interface ILoginPageService {

	public boolean addUser(LoginPage object);

	public boolean checkValidation(LoginPage object);
}
