package com.loginpage.dao;

import com.loginpage.model.LoginPage;

public interface ILoginPageDao {
	public boolean addUser(LoginPage object);

	public boolean checkValidation(LoginPage object);
}
